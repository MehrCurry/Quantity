package de.gzockoll.quantity;

public class Quantity implements Comparable<Quantity> {
	public static final Quantity ZERO = new ZeroQuantity();
	protected long amount;
	protected Unit unit;
	public Quantity(long amount, Unit unit) {
		super();
		this.amount = amount;
		this.unit = unit;
	}
	
	public Unit getUnit() {
		return unit;
	}

	public Quantity add(Quantity other) {
		assertSameUnit(other);
		return new Quantity(amount + other.getAmount(),unit);
	}

	public Quantity sub(Quantity other) {
		assertSameUnit(other);
		return new Quantity(amount - other.getAmount(),unit);
	}

	private void assertSameUnit(Quantity other) {
		if (!unit.equals(other.unit))
			throw new IllegalArgumentException("Units are not compatible:" + unit + " and " + other.unit);
	}
	
	public long getAmount() {
		return amount;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Quantity)
			return equals((Quantity) obj);
		else
			return false;
	}

	public boolean equals(Quantity other) {
		return amount == other.amount && unit.equals(other.unit);
	}
	
	@Override
	public int hashCode() {
		return (int) (2 * amount + 3 * unit.hashCode());
	}
	
	public boolean isGreater(Quantity other) {
		assertSameUnit(other);
		return amount > other.amount;
	}
	
	public boolean isGreaterOrEqual(Quantity other) {
		assertSameUnit(other);
		return amount >= other.amount;
	}
	
	public boolean isLess(Quantity other) {
		assertSameUnit(other);
		return amount < other.amount;
	}

	public boolean isLessOrEqualn(Quantity other) {
		assertSameUnit(other);
		return amount <= other.amount;
	}

	public int compareTo(Quantity other) {
		assertSameUnit(other);
		return Long.valueOf(amount).compareTo(Long.valueOf(other.amount));
	}

	public static Quantity zero(Unit unit) {
		return new Quantity(0, unit);
	}

	public boolean isZero() {
		return amount==0;
	}
	
	public Quantity negate() {
		return new Quantity(-amount,unit);
	}

	private static class ZeroQuantity extends Quantity {
		public ZeroQuantity() {
			super(0, null);
		}

		@Override
		public Quantity add(Quantity other) {
			return other;
		}
		
		@Override
		public Quantity sub(Quantity other) {
			return other.negate();
		}
		
		@Override
		public boolean equals(Quantity other) {
			return amount == other.amount;
		}
	}
	
	@Override
	public String toString() {
		return amount + " " + unit;
	}

}
