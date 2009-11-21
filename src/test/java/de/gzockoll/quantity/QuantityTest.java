package de.gzockoll.quantity;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class QuantityTest {

	private static final int COUNT = 100000;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHashCode() {
		Quantity q1=Quantity.zero(Units.KG);
		Quantity q2=new Quantity(0,Units.KG);
		Quantity q3=Quantity.zero(Units.KWH);
		Quantity q4=new Quantity(1,Units.KG);
		assertThat(q1.hashCode(),is(q2.hashCode()));
		assertThat(q2.hashCode(),is(not(q3.hashCode())));
		assertThat(q2.hashCode(),is(not(q4.hashCode())));		
	}

	public void testHashCodeLoop() {
		List<Quantity> list=new ArrayList<Quantity>();
		for (int i=0;i<COUNT;i++) {
			list.add(new Quantity(i, Units.KWH));
		}
		
		for (int i=0;i<COUNT;i++) {
			for (int j=0;i<COUNT;i++) {
				if (i==j)
					assertThat(list.get(i).hashCode(),is(list.get(j).hashCode()));
				else
					assertThat(list.get(i).hashCode(),is(not(list.get(j).hashCode())));
			}
		}
	}
	
	@Test
	public void testGetUnit() {
		Quantity q1=Quantity.zero(Units.KG);
		Quantity q2=Quantity.zero(Units.KG);
		assertThat(q1.getUnit().equals(Units.KG),is(true));
		assertThat(q2.getUnit().equals(Units.KWH),is(false));
	}

	@Test
	public void testAdd() {
		Quantity q1=new Quantity(2,Units.KG);
		Quantity q2=new Quantity(4,Units.KG);
		assertThat(q1.add(q2),is(new Quantity(6, Units.KG)));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddWrongUnits() {
		Quantity q1=new Quantity(2,Units.KG);
		Quantity q2=new Quantity(4,Units.KWH);
		q1.add(q2);
	}

	@Test
	public void testSub() {
		Quantity q1=new Quantity(2,Units.KG);
		Quantity q2=new Quantity(4,Units.KG);
		assertThat(q2.sub(q1).sub(q1),is(Quantity.zero(Units.KG)));
	}

	@Test
	public void testGetAmount() {
		Quantity q1=new Quantity(2,Units.KG);
		assertThat(q1.getAmount(),is(2l));
	}

	@Test
	public void testEqualsObject() {
		Quantity q1=new Quantity(2,Units.KG);
		Quantity q2=new Quantity(3,Units.KG);
		Quantity q3=new Quantity(2,Units.KWH);
		assertThat(q1.equals(2),is(false));
		assertThat(q1.equals(q1),is(true));
		assertThat(q1.equals(q2),is(false));
		assertThat(q1.equals(q3),is(false));
	}

	@Test
	public void testIsGreater() {
		Quantity q1=new Quantity(2,Units.KG);
		Quantity q2=new Quantity(3,Units.KG);
		Quantity q3=new Quantity(3,Units.KG);
		assertThat(q1.isGreater(q2),is(false));
		assertThat(q2.isGreater(q1),is(true));
		assertThat(q2.isGreater(q3),is(false));
		assertThat(q3.isGreater(q2),is(false));
	}

	@Test
	public void testIsGreaterOrEqual() {
		Quantity q1=new Quantity(2,Units.KG);
		Quantity q2=new Quantity(3,Units.KG);
		Quantity q3=new Quantity(3,Units.KG);
		assertThat(q1.isGreaterOrEqual(q2),is(false));
		assertThat(q2.isGreaterOrEqual(q1),is(true));
		assertThat(q2.isGreaterOrEqual(q3),is(true));
		assertThat(q3.isGreaterOrEqual(q2),is(true));
	}
//
//	@Test
//	public void testIsLess() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIsLessOrEqualn() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCompareTo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testZero() {
//		fail("Not yet implemented");
//	}

}
