package org.effrafax.underground.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
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
		Order.create((LocalDate) null);
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

		LocalDate expectedOrderDate = new LocalDate(2011, 5, 12);
		assertEquals(expectedOrderDate, Order.create(expectedOrderDate).getOrderDate());
	}

	@Test
	public void shouldReturnDefaultClosingTimeWhenConstructedWithoutExplicitClosingTime()
	{
		LocalTime expectedClosingTime = new LocalTime(10, 15);
		assertEquals(expectedClosingTime, Order.create().getClosingTime());
	}

	@Test
	public void shouldReturnExpectedLocalTimeWhenConstructedWithExplicitClosingTime()
	{
		LocalTime expectedClosingTime = new LocalTime(12, 34);
		assertEquals(expectedClosingTime, Order.create(expectedClosingTime).getClosingTime());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenConstructedWithANullClosingTime()
	{
		Order.create((LocalTime) null);
	}

	@Test
	public void shouldReturnExpectedOrderDateAndClosingTimeWhenExplicitlyConstructed()
	{
		LocalDate expectedOrderDate = new LocalDate(2011, 2, 9);
		LocalTime expectedClosingTime = new LocalTime(12, 34);

		Order order = Order.create(expectedOrderDate, expectedClosingTime);
		assertEquals(expectedOrderDate, order.getOrderDate());
		assertEquals(expectedClosingTime, order.getClosingTime());
	}
}
