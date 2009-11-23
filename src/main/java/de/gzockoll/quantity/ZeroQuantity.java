package de.gzockoll.quantity;

class ZeroQuantity implements Quantity {
	@Override
	public Quantity add(Quantity other) {
		return other;
	}

	@Override
	public Quantity sub(Quantity other) {
		return other.negate();
	}

	@Override
	public long getAmount() {
		return 0;
	}

	@Override
	public Unit getUnit() {
		return null;
	}

	@Override
	public Quantity negate() {
		return this;
	}

	@Override
	public Quantity newInstance(long amount, Unit unit) {
		return new ZeroQuantity();
	}

	@Override
	public Quantity newInstanceFromQuantity(Quantity a) {
		return new ZeroQuantity();
	}

	public boolean equals(Object obj) {
		return false;
	}

	public int hashCode() {
		return 0;
	}

	public boolean isGreater(SimpleQuantity other) {
		return false;
	}

	public boolean isGreaterOrEqual(SimpleQuantity other) {
		return false;
	}

	public boolean isLess(SimpleQuantity other) {
		return false;
	}

	public boolean isLessOrEqualn(SimpleQuantity other) {
		return false;
	}

	public int compareTo(Quantity other) {
		return 0;
	}
}