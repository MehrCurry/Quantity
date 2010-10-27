package de.gzockoll.quantity;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractQuantityTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() {
		Quantity q1=new AbstractQuantity<Long>(1L,Units.KG);
		Quantity q2=new AbstractQuantity<Long>(2L,Units.KG);
		assertThat(q1.add(q2),is((Quantity) new AbstractQuantity<Long>(3l,Units.KG)));
	}

}
