package de.gzockoll.quantity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class BigDecimalQuantity implements Quantity<BigDecimal> {
	protected BigDecimal amount=new BigDecimal(0);
	protected Unit unit;
	

	public BigDecimalQuantity(BigDecimal amount, Unit unit) {
		super();
		this.amount = amount;
		this.unit = unit;
	}

	public BigDecimalQuantity(int iAmount, Units unit) {
		this(new BigDecimal(iAmount),unit);
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
	public BigDecimalQuantity negate() {
		return new BigDecimalQuantity(amount.negate(),unit);
	}

	@Override
	public BigDecimalQuantity add(Quantity<BigDecimal> other) {
		assertSameUnit(other);
		return new BigDecimalQuantity(amount.add(other.getAmount()),unit);
	}

	@Override
	public BigDecimalQuantity sub(Quantity<BigDecimal>  other) {
		assertSameUnit(other);
		return new BigDecimalQuantity(amount.subtract(other.getAmount()),unit);
	}

	public BigDecimalQuantity multiply(BigDecimal factor) {
		return new BigDecimalQuantity(amount.multiply(factor), unit);
	}
	
	@Override
	public int compareTo(Quantity<BigDecimal> other) {
		assertSameUnit(other);
		return amount.compareTo(other.getAmount());
	}

	private void assertSameUnit(Quantity<BigDecimal> other) {
		if (!unit.equals(other.getUnit()))
			throw new IllegalArgumentException("Incompatible Units: " + unit + " and " + other.getAmount());		
	}

	@Override
	public boolean isZero() {
		return BigDecimal.ZERO.equals(amount);
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public String toString() {
		return amount + "[" + unit + "]";
	}
}
