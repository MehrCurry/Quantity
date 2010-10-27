package de.gzockoll.quantity;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BigDecimalQuantityTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBigDecimalQuantity() {
		BigDecimalQuantity q=new BigDecimalQuantity(1, Units.KG);
		assertThat(q.getAmount(),is(new BigDecimal(1)));
		assertThat(q.getUnit(),is((Unit)Units.KG));
	}

	@Test
	public void testNegate() {
		BigDecimalQuantity q=new BigDecimalQuantity(1, Units.KG).negate();
		assertThat(q.getAmount(),is(new BigDecimal(-1)));
		assertThat(q.getUnit(),is((Unit)Units.KG));
	}

	@Test
	public void testAdd() {
		BigDecimalQuantity q1=new BigDecimalQuantity(1, Units.KG);
		BigDecimalQuantity q2=new BigDecimalQuantity(2, Units.KG);
		BigDecimalQuantity q3=new BigDecimalQuantity(3, Units.KG);
		assertThat(q1.add(q2),is(q3));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddWithDifferentUnits() {
		BigDecimalQuantity q1=new BigDecimalQuantity(1, Units.KG);
		BigDecimalQuantity q2=new BigDecimalQuantity(2, Units.KWH);
		BigDecimalQuantity q3=new BigDecimalQuantity(3, Units.KG);
		assertThat(q1.add(q2),is(q3));
	}

	@Test
	public void testSub() {
		BigDecimalQuantity q1=new BigDecimalQuantity(4, Units.KG);
		BigDecimalQuantity q2=new BigDecimalQuantity(3, Units.KG);
		BigDecimalQuantity q3=new BigDecimalQuantity(1, Units.KG);
		assertThat(q1.sub(q2),is(q3));
	}

	@Test
	public void testCompareTo() {
		BigDecimalQuantity q1=new BigDecimalQuantity(4, Units.KG);
		BigDecimalQuantity q2=new BigDecimalQuantity(2, Units.KG);
		BigDecimalQuantity q3=new BigDecimalQuantity(2, Units.KG);
		BigDecimalQuantity q4=new BigDecimalQuantity(1, Units.KG);
		assertThat(q1.compareTo(q2),is(1));
		assertThat(q2.compareTo(q3),is(0));
		assertThat(q2.compareTo(q1),is(-1));
	}

	@Test
	public void testIsZero() {
		BigDecimalQuantity q1=new BigDecimalQuantity(0, Units.KG);
		BigDecimalQuantity q2=new BigDecimalQuantity(4, Units.KG);
		assertThat(q1.isZero(),is(true));
		assertThat(q2.isZero(),is(false));
	}

}
