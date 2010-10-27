package de.gzockoll.quantity;

import java.math.BigDecimal;

public class BigDecimalQuantity implements Quantity<BigDecimal>{
	protected BigDecimal amount = new BigDecimal(0);
	protected Unit unit;
	
	public BigDecimalQuantity(BigDecimal amount, Unit unit) {
		super();
		this.amount = amount;
		this.unit = unit;
	}

	public BigDecimalQuantity(int i, Unit unit) {
		super();
		this.amount = new BigDecimal(i);
		this.unit = unit;
	}

	@Override
	public Unit getUnit() {
		return unit;
	}

	@Override
	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public Quantity<BigDecimal> negate() {
		return new BigDecimalQuantity(amount.negate(),unit);
	}

	@Override
	public Quantity<BigDecimal> add(Quantity<BigDecimal> other) {
		assertSameUnit(other);
		return new BigDecimalQuantity(amount.add(other.getAmount()),unit);
	}

	private void assertSameUnit(Quantity<BigDecimal> other) {
		if (!this.unit.equals(other.getUnit()))
			throw new IllegalArgumentException("Incompatible units: " + this.unit + " and " + other.getUnit());
		
	}

	@Override
	public Quantity<BigDecimal> sub(Quantity<BigDecimal> other) {
		assertSameUnit(other);
		return new BigDecimalQuantity(amount.subtract(other.getAmount()),unit);
	}

//	@Override
//	public Quantity<BigDecimal> newInstance(Number number, Unit unit) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Quantity<BigDecimal> newInstanceFromQuantity(Quantity<BigDecimal> a) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int compareTo(Quantity<BigDecimal> other) {
		assertSameUnit(other);
		return amount.compareTo(other.getAmount());
	}

	@Override
	public boolean isZero() {
		return amount.equals(BigDecimal.ZERO);
	}

	@Override
	public boolean isGreater(Quantity<BigDecimal> other) {
		return compareTo(other)>0;
	}

	@Override
	public boolean isGreaterOrEqual(Quantity<BigDecimal> other) {
		return compareTo(other)>=0;
	}

	@Override
	public String toString() {
		return amount + " " + unit;
	}
	
	@Override
	public boolean equals(Object obj) {
		BigDecimalQuantity other=(BigDecimalQuantity) obj;
		return amount.equals(other.amount) & unit.equals(other.unit);
	}
	
	@Override
	public int hashCode() {
		return 2*amount.hashCode()+3*unit.hashCode();
	}

	@Override
	public Quantity<BigDecimal> multiply(BigDecimal val) {
		return new BigDecimalQuantity(amount.multiply(val), unit);
	}
	
	public Quantity<BigDecimal> divide(BigDecimal divisor) {
		return new BigDecimalQuantity(amount.divide(divisor), unit);
	}

	public Quantity<BigDecimal> divide(int divisor) {
		return divide(new BigDecimal(divisor));
	}
}
