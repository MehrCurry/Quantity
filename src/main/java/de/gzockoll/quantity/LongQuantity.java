package de.gzockoll.quantity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class LongQuantity implements Quantity<Long> {
	private Long amount=new Long(0);
	private Unit unit;
	

	public LongQuantity(Long amount, Unit unit) {
		super();
		this.amount = amount;
		this.unit = unit;
	}

	public LongQuantity(int iAmount, Units unit) {
		this(new Long(iAmount),unit);
	}

	@Override
	public Unit getUnit() {
		return unit;
	}

	@Override
	public Long getAmount() {
		return amount;
	}

	@Override
	public LongQuantity negate() {
		return new LongQuantity(-amount,unit);
	}

	@Override
	public LongQuantity add(Quantity<Long> other) {
		assertSameUnit(other);
		return new LongQuantity(amount+other.getAmount(),unit);
	}

	@Override
	public LongQuantity sub(Quantity<Long>  other) {
		assertSameUnit(other);
		return new LongQuantity(amount-other.getAmount(),unit);
	}

	@Override
	public int compareTo(Quantity<Long> other) {
		assertSameUnit(other);
		return amount.compareTo(other.getAmount());
	}

	private void assertSameUnit(Quantity other) {
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
