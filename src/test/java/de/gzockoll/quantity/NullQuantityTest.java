package de.gzockoll.quantity;


import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NullQuantityTest {

	private NullQuantity q1;
	private Quantity q2;

	@Before
	public void setUp() throws Exception {
		q1=new NullQuantity();
		q2=Units.KG.amount(10);
	}
	
	@Test
	public void testIsZero() {
		assertThat(q1.isZero(),is(true));
	}
	
	@Test
	public void testAdd() {
		
		assertThat(q1.add(q2),is(q2));
		assertThat(q2.add(q1),is(q2));
	}
	
	@Test
	public void testSub() {
		assertThat(q1.sub(q2),is(q2.negate()));
		assertThat(q2.sub(q1),is(q2));		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCompareTo1() {
		assertThat(q1.compareTo(q2),is(-1));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCompareTo2() {
		assertThat(q2.compareTo(q1),is(1));
	}

	@Test
	public void testCompareTo3() {
		assertThat(q1.compareTo(q1),is(0));
	}
}
