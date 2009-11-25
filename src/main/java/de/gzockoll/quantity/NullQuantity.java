package de.gzockoll.quantity;

public class NullQuantity implements Quantity {
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
		return new Unit() { /* NullObject Pattern */
		};
	}

	@Override
	public Quantity negate() {
		return this;
	}

	@Override
	public Quantity newInstance(long amount, Unit unit) {
		return new NullQuantity();
	}

	@Override
	public Quantity newInstanceFromQuantity(Quantity a) {
		return new NullQuantity();
	}

	public boolean equals(Object obj) {
		return false;
	}

	public int hashCode() {
		return 0;
	}

	public boolean isGreater(SimpleQuantity other) {
		return compareTo(other)>0;
	}

	public boolean isGreaterOrEqual(SimpleQuantity other) {
		return compareTo(other)>=0;
	}

	public boolean isLess(SimpleQuantity other) {
		return compareTo(other)<0;
	}

	public boolean isLessOrEqualn(SimpleQuantity other) {
		return compareTo(other)<=0;
	}

	public int compareTo(Quantity other) {
		if (other instanceof NullQuantity)
			return 0;
		else
			return -other.compareTo(this);
	}

	@Override
	public boolean isZero() {
		return true;
	}
}