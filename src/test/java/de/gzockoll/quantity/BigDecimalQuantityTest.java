package de.gzockoll.quantity;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BigDecimalQuantityTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() {
		BigDecimalQuantity q1=new BigDecimalQuantity(1,Units.KG);
		BigDecimalQuantity q2=new BigDecimalQuantity(2,Units.KG);
		Quantity<BigDecimal> result = q1.add(q2);
		assertThat(result,is((Quantity<BigDecimal>) new BigDecimalQuantity(3,Units.KG)));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddWithWrongUnit() {
		BigDecimalQuantity q1=new BigDecimalQuantity(1,Units.KG);
		BigDecimalQuantity q2=new BigDecimalQuantity(2,Units.KWH);
		Quantity<BigDecimal> result = q1.add(q2);
	}

	@Test
	public void testSub() {
		BigDecimalQuantity q1=new BigDecimalQuantity(3,Units.KG);
		BigDecimalQuantity q2=new BigDecimalQuantity(2,Units.KG);
		Quantity<BigDecimal> result = q1.sub(q2);
		assertThat(result,is((Quantity<BigDecimal>) new BigDecimalQuantity(1,Units.KG)));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSubWithWrongUnit() {
		BigDecimalQuantity q1=new BigDecimalQuantity(3,Units.KG);
		BigDecimalQuantity q2=new BigDecimalQuantity(2,Units.KWH);
		Quantity<BigDecimal> result = q1.sub(q2);
	}
	
	@Test
	public void testDivideWithBigDecimal() {
		BigDecimalQuantity q1=new BigDecimalQuantity(4,Units.KG);
		Quantity<BigDecimal> result = q1.divide(new BigDecimal(2));
		assertThat(result,is((Quantity<BigDecimal>) new BigDecimalQuantity(2,Units.KG)));
	}

	@Test
	public void testDivideWithInteger() {
		BigDecimalQuantity q1=new BigDecimalQuantity(4,Units.KG);
		Quantity<BigDecimal> result = q1.divide(2);
		assertThat(result,is((Quantity<BigDecimal>) new BigDecimalQuantity(2,Units.KG)));
	}

}
