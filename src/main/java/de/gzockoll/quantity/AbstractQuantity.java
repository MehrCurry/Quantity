package de.gzockoll.quantity;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AbstractQuantity<T extends Number>  implements Comparable<Quantity<T>>, Quantity<T> {
	protected T amount;
	protected Unit unit;
	
	protected AbstractQuantity(T number, Unit unit) {
		super();
		this.amount = number;
		this.unit = unit;
	}

	public AbstractQuantity(Quantity<T> q) {
		this(q.getAmount(),q.getUnit());
	}

	
	public T getAmount() {
		return amount;
	}

	public Unit getUnit() {
		return unit;
	}

	/* (non-Javadoc)
	 * @see de.gzockoll.quantity.Quantity#add(de.gzockoll.quantity.SimpleQuantity)
	 */
	@Override
	public Quantity<T> add(Quantity<T> other) {
		if (other instanceof NullQuantity)
			return this;
		assertSameUnit(other);
		return newInstance(add(getAmount(),other.getAmount()),getUnit());
	}

	private Number add(Number a, Number b) {
		if (a instanceof BigDecimal || b instanceof BigDecimal)
			return new BigDecimal(a.toString()).add(new BigDecimal(b.toString()));
		if (a instanceof Long || b instanceof Long)
			return new Long(a.longValue()+b.longValue());
		throw new IllegalArgumentException();
	}
	
	private Number sub(Number a, Number b) {
		return new BigDecimal(a.doubleValue()).subtract(new BigDecimal(b.doubleValue()));
	}
	

	@Override
	public Quantity<T> sub(Quantity<T> other) {
		if (other instanceof NullQuantity)
			return this;
		assertSameUnit(other);
		return newInstance(sub(getAmount(),other.getAmount()),getUnit());
	}

	void assertSameUnit(Quantity<T> other) {
		if (!getUnit().equals(other.getUnit()))
			throw new IllegalArgumentException("Units are not compatible:" + getUnit() + " and " + other.getUnit());
	}
	
	@Override
	public Quantity<T> negate() {
		return newInstance(negate(amount), unit);
	}

	@SuppressWarnings("unchecked")
	private T negate(T val) {
		if (val instanceof BigInteger)
			return (T) ((BigInteger)val).negate();
		if (val instanceof BigDecimal)
			return (T) ((BigDecimal) val).negate();
		if (val instanceof Double)
			return (T) new Double(-val.doubleValue());
		if (val instanceof Float)
			return (T) new Float(-val.floatValue());
		if (val instanceof Long)
			return (T) new Long(-val.longValue());
		if (val instanceof Integer)
			return (T) new Integer(-val.intValue());
		if (val instanceof Short)
			return (T) new Short((short) -val.shortValue());
		if (val instanceof Byte)
			return (T) new Byte((byte) -val.byteValue());
		if (val instanceof Integer)
			return (T) new Integer(-val.intValue());
		
		throw new IllegalArgumentException();
	}

	@Override
	public boolean equals(Object obj) {
		Quantity<T> other=(Quantity<T>) obj;
		return amount.equals(other.getAmount()) && unit.equals(other.getUnit());
	}

	@Override
	public int hashCode() {
		return amount.hashCode() + 3*unit.hashCode();
	}

	public boolean isGreater(Quantity<T> other) {
		return compareTo(other) > 0;
	}

	public boolean isGreaterOrEqual(Quantity<T> other) {
		return compareTo(other) >= 0;
	}

	public boolean isLess(Quantity<T> other) {
		return compareTo(other) < 0;
 	}

	public boolean isLessOrEqualn(Quantity<T> other) {
		return compareTo(other) <=0;
	}

	public int compareTo(Quantity<T> other) {
		assertSameUnit(other);
		return compareTo(amount,other.getAmount());
	}
	
	private int compareTo(Number a, Number b) {
		return new BigDecimal(a.doubleValue()).compareTo(new BigDecimal(b.doubleValue()));
	}

	@Override
	public String toString() {
		return amount + " " + unit;
	}
	
	@Override
	public boolean isZero() {
		return new BigDecimal(0).equals(new BigDecimal(amount.doubleValue()));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@Override
	public Quantity<T> newInstance(Number number, Unit unit) {
		return new AbstractQuantity(number, unit);
	}

//	@Override
	public Quantity<T> newInstanceFromQuantity(Quantity<T> a) {
		return newInstance(a.getAmount(), a.getUnit());
	}

	public static AbstractQuantity zero(Unit unit) {
		return new AbstractQuantity<Number>(0,unit);
	}

	@Override
	public Quantity<T> multiply(T val) {
		throw new UnsupportedOperationException(getClass().getName() + "does not understand method post()");
	}
}
