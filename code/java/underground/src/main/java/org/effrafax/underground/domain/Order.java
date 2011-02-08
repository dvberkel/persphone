package org.effrafax.underground.domain;

import java.io.Serializable;

import org.joda.time.LocalDate;

public class Order implements Serializable
{
	private static final long serialVersionUID = 37L;

	private final LocalDate orderDate;

	public static Order create(LocalDate orderDate)
	{
		if (orderDate == null)
		{
			throw new IllegalArgumentException("orderDate should not be null.");
		}
		return new Order(orderDate);
	}

	public static Order create()
	{
		return create(new LocalDate());
	}

	private Order(LocalDate orderDate)
	{
		this.orderDate = orderDate;
	}

	public LocalDate getOrderDate()
	{
		return orderDate;
	}

}
