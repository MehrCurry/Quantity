package de.gzockoll.quantity;

public final class SimpleQuantity extends AbstractQuantity implements
		Comparable<Quantity>, Quantity {

	public SimpleQuantity(long amount, Unit unit) {
		super(amount,unit);
	}

	public SimpleQuantity(Quantity q) {
		super(q);
	}

	@Override
	public Quantity newInstanceFromQuantity(Quantity q) {
		return new SimpleQuantity(q);
	}

	@Override
	public Quantity newInstance(long amount, Unit unit) {

		return new SimpleQuantity(amount, unit);
	}

	public static Quantity zero(Unit unit) {
		return new SimpleQuantity(0,unit);
	}
}
