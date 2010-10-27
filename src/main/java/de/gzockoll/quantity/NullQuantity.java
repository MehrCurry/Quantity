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
	public Number getAmount() {
		return 0;
	}

	@Override
	public Unit getUnit() {
		throw new UnsupportedOperationException(getClass().getName() + "does not understand method post()");
	}

	@Override
	public Quantity negate() {
		return this;
	}

	public boolean equals(Object obj) {
		return false;
	}

	public int hashCode() {
		return 0;
	}

	public boolean isGreater(Quantity other) {
		return compareTo(other)>0;
	}

	public boolean isGreaterOrEqual(Quantity other) {
		return compareTo(other)>=0;
	}

	public boolean isLess(Quantity other) {
		return compareTo(other)<0;
	}

	public boolean isLessOrEqualn(Quantity other) {
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

	@Override
	public Quantity multiply(Number val) {
		return this;
	}
}