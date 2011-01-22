package org.effrafax.underground.web.order.panel;

import org.apache.wicket.markup.html.panel.Panel;
import org.effrafax.underground.web.order.panel.component.OrderInputComponent;

public class OrderCreationPanel extends Panel
{
	private static final long serialVersionUID = 37L;

	public OrderCreationPanel(String id)
	{
		super(id);
		add(new OrderInputComponent("orderInputComponent"));
	}

}