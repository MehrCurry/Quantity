package de.gzockoll.quantity;

public interface Quantity {

	Unit getUnit();

	long getAmount();

	Quantity negate();

	Quantity add(Quantity other);

	Quantity sub(Quantity other);

	Quantity newInstance(long amount,Unit unit);

	Quantity newInstanceFromQuantity(Quantity a);

	@Override
	public boolean equals(Object obj);

	@Override
	public int hashCode();

	public int compareTo(Quantity other);
	
	boolean isZero();
}