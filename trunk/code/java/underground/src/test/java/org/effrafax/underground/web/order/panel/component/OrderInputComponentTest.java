package org.effrafax.underground.web.order.panel.component;

import org.apache.wicket.model.Model;
import org.effrafax.underground.domain.Order;
import org.effrafax.underground.util.test.UndergroundWicketTest;
import org.effrafax.underground.web.order.panel.component.OrderInputComponent;
import org.junit.Test;

public class OrderInputComponentTest extends UndergroundWicketTest
{
	@Test
	public void shouldRenderCorrectly()
	{
		Model<Order> orderModel = new Model<Order>(Order.create());
		OrderInputComponent orderInputComponent = new OrderInputComponent("orderInputComponent", orderModel);
		getTester().startComponent(orderInputComponent);
		getTester().assertNoErrorMessage();
	}
}
