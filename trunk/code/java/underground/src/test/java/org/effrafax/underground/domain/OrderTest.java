package org.effrafax.underground.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class OrderTest
{
	private Order order;

	@Before
	public void createOrder()
	{
		order = Order.create();
	}

	@Test
	public void shouldBePossibleToConstructAnOrder()
	{
		assertNotNull(order);
	}
}
