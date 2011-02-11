package org.effrafax.underground.domain.model;

import java.io.Serializable;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class Order implements Serializable
{
	private static final long serialVersionUID = 37L;

	private static final LocalTime DEFAULT_CLOSING_DATE = new LocalTime(10, 15);

	private final LocalDate orderDate;

	private final LocalTime closingTime;

	public static Order create(LocalDate orderDate, LocalTime closingTime)
	{
		if (orderDate == null)
		{
			throw new IllegalArgumentException("orderDate should not be null.");
		}
		if (closingTime == null)
		{
			throw new IllegalArgumentException("closingTime should not be null.");
		}
		return new Order(orderDate, closingTime);
	}

	public static Order create(LocalDate orderDate)
	{
		return create(orderDate, DEFAULT_CLOSING_DATE);
	}

	public static Order create(LocalTime closingTime)
	{
		return create(new LocalDate(), closingTime);
	}

	public static Order create()
	{
		return create(new LocalDate());
	}

	private Order(LocalDate orderDate, LocalTime closingTime)
	{
		this.orderDate = orderDate;
		this.closingTime = closingTime;
	}

	public LocalDate getOrderDate()
	{
		return orderDate;
	}

	public LocalTime getClosingTime()
	{
		return closingTime;
	}
}
