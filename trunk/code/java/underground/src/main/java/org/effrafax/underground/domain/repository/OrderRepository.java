package org.effrafax.underground.domain.repository;

import java.util.Collection;

import org.effrafax.underground.domain.model.Order;

public interface OrderRepository
{

	public Collection<Order> getAll();

	public void save(Order order);

}