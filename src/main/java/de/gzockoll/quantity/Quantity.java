package de.gzockoll.quantity;

public interface Quantity<T extends Number> {

	Unit getUnit();

	T getAmount();

	Quantity<T> negate();

	Quantity<T> add(Quantity<T> other);

	Quantity<T> sub(Quantity<T> other);

	@Override
	public boolean equals(Object obj);

	@Override
	public int hashCode();

	public int compareTo(Quantity<T> other);
	
	boolean isZero();
}