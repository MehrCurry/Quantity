package de.gzockoll.quantity;

public interface Quantity<T extends Number> {

	Unit getUnit();

	T getAmount();

	Quantity<T> negate();

	Quantity<T> add(Quantity<T> other);

	Quantity<T> sub(Quantity<T> other);

	Quantity<T> multiply(T val);

	//	Quantity<T> newInstance(Number number,Unit unit);
//
//	Quantity<T> newInstanceFromQuantity(Quantity<T> a);

	@Override
	public boolean equals(Object obj);

	@Override
	public int hashCode();

	public int compareTo(Quantity<T> other);
	
	boolean isZero();

	boolean isGreater(Quantity<T> other);

	boolean isGreaterOrEqual(Quantity<T> other);
}