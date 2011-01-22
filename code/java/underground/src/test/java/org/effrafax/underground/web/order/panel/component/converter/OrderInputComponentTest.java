package org.effrafax.underground.web.order.panel.component.converter;

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
		OrderInputComponent orderInputComponent = new OrderInputComponent("orderInputComponent", new Model<Order>(Order
			.create()));
		getTester().startComponent(orderInputComponent);
		getTester().assertNoErrorMessage();
	}
}
