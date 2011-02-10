package org.effrafax.underground.web.order.panel.component;

import org.apache.wicket.model.Model;
import org.effrafax.underground.domain.Order;
import org.effrafax.underground.util.test.UndergroundWicketTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class OrderInputComponentTest extends UndergroundWicketTest
{
	private OrderInputComponent orderInputComponent;

	@Before
	public void createOrderInputComponent()
	{
		Model<Order> orderModel = new Model<Order>(Order.create());
		orderInputComponent = new OrderInputComponent("orderInputComponent", orderModel);
	}

	@Ignore
	@Test
	public void shouldRenderCorrectly()
	{
		getTester().startComponent(orderInputComponent);
		getTester().assertNoErrorMessage();
	}

	@Ignore
	@Test
	public void shouldHaveAnLocalDateField()
	{
		getTester().startComponent(orderInputComponent);
		getTester().assertComponent("panel:component:orderDate", LocalDateField.class);
	}

	@Ignore
	@Test
	public void shouldHaveAnLocalTimeField()
	{
		getTester().startComponent(orderInputComponent);
		getTester().assertComponent("panel:component:closingTime", LocalTimeField.class);
	}
}
