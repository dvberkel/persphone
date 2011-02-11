package org.effrafax.underground.domain.repository.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.effrafax.underground.domain.model.Order;
import org.effrafax.underground.domain.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;

public class InMemoryOrderRepositoryTest
{

	private OrderRepository repository;

	@Before
	public void createInMemoryOrderRepository()
	{
		repository = new InMemoryOrderRepository();
	}

	@Test
	public void inMemoryOrderRepositoryCanBeConstructed()
	{
		assertNotNull(repository);
	}

	@Test
	public void shouldBeAbleToRetrieveAllOrders()
	{
		assertTrue(repository.getAll().size() == 0);
	}

	@Test
	public void shouldBeAbleToSaveAnOrder()
	{
		Order order = Order.create();
		repository.save(order);
		assertTrue(repository.getAll().size() == 1);
		assertTrue(repository.getAll().contains(order));
	}

	@Test
	public void shouldImplementOrderRepository()
	{
		assertTrue(repository instanceof OrderRepository);
	}
}
