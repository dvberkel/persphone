package org.effrafax.underground.web.order.panel;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.effrafax.underground.domain.Order;
import org.effrafax.underground.web.order.panel.component.OrderInputComponent;

public class OrderCreationPanel extends Panel
{
	private static final long serialVersionUID = 37L;

	private Order order = null;

	public OrderCreationPanel(String id)
	{
		super(id);
		add(new OrderInputComponent("orderInputComponent", new PropertyModel<Order>(this, "order")));
	}

}
