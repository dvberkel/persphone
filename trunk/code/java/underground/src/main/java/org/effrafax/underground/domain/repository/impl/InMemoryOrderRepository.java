package org.effrafax.underground.domain.repository.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.effrafax.underground.domain.model.Order;
import org.effrafax.underground.domain.repository.OrderRepository;

public class InMemoryOrderRepository implements OrderRepository
{

	private List<Order> orders = new ArrayList<Order>();

	public Collection<Order> getAll()
	{
		return orders;
	}

	public void save(Order order)
	{
		orders.add(order);
	}

}
