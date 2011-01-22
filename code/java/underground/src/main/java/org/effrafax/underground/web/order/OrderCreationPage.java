package org.effrafax.underground.web.order;

import org.apache.wicket.markup.html.WebPage;
import org.effrafax.underground.web.order.panel.OrderCreationPanel;

public class OrderCreationPage extends WebPage
{
	public OrderCreationPage()
	{
		add(new OrderCreationPanel("orderCreationPanel"));
	}
}
