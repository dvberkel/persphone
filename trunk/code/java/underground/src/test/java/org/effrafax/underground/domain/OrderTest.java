package org.effrafax.underground.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.joda.time.LocalDate;
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

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenConstructedWithANullLocalDate()
	{
		Order.create(null);
	}

	@Test
	public void shouldBePossibleToConstructAnOrderForACertainDate()
	{
		assertNotNull(Order.create(new LocalDate(2011, 1, 22)));
	}

	@Test
	public void shouldReturnTodayAsOrderDateWhenConstructedWithoutExpliciteOrderDate()
	{
		assertEquals(new LocalDate(), Order.create().getOrderDate());
	}

	@Test
	public void shouldReturnExpectedLocalDateAsOrderDateWhenConstructedWithExpliciteOrderDate()
	{

		LocalDate expectedLocalDate = new LocalDate(2011, 5, 12);
		assertEquals(expectedLocalDate, Order.create(expectedLocalDate).getOrderDate());
	}
}
