package de.gzockoll.quantity;

public abstract class AbstractQuantity  implements Comparable<Quantity>, Quantity {
	protected long amount;
	protected Unit unit;
	
	protected AbstractQuantity(long amount, Unit unit) {
		super();
		this.amount = amount;
		this.unit = unit;
	}

	public AbstractQuantity(Quantity q) {
		this(q.getAmount(),q.getUnit());
	}

	
	public long getAmount() {
		return amount;
	}

	public Unit getUnit() {
		return unit;
	}

	/* (non-Javadoc)
	 * @see de.gzockoll.quantity.Quantity#add(de.gzockoll.quantity.SimpleQuantity)
	 */
	@Override
	public Quantity add(Quantity other) {
		if (other instanceof NullQuantity)
			return this;
		assertSameUnit(other);
		return newInstance(getAmount() + other.getAmount(),getUnit());
	}

	@Override
	public Quantity sub(Quantity other) {
		if (other instanceof NullQuantity)
			return this;
		assertSameUnit(other);
		return newInstance(getAmount() - other.getAmount(),getUnit());
	}
	
	void assertSameUnit(Quantity other) {
		if (!getUnit().equals(other.getUnit()))
			throw new IllegalArgumentException("Units are not compatible:" + getUnit() + " and " + other.getUnit());
	}
	
	@Override
	public Quantity negate() {
		return newInstance(-amount, unit);
	}

	@Override
	public boolean equals(Object obj) {
		Quantity other=(Quantity) obj;
		return Long.valueOf(amount).equals(other.getAmount()) && unit.equals(other.getUnit());
	}

	@Override
	public int hashCode() {
		return 2*Long.valueOf(amount).hashCode() + 3*unit.hashCode();
	}

	public boolean isGreater(Quantity other) {
		return compareTo(other) > 0;
	}

	public boolean isGreaterOrEqual(Quantity other) {
		return compareTo(other) >= 0;
	}

	public boolean isLess(Quantity other) {
		return compareTo(other) < 0;
 	}

	public boolean isLessOrEqualn(Quantity other) {
		return compareTo(other) <=0;
	}

	public int compareTo(Quantity other) {
		assertSameUnit(other);
		return Long.valueOf(amount).compareTo(other.getAmount());
	}
	
	@Override
	public String toString() {
		return amount + " " + unit;
	}
	
	@Override
	public boolean isZero() {
		return amount==0;
	}
}
