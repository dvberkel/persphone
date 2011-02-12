package org.effrafax.underground.web.order.overview.panel.component;

import org.apache.wicket.markup.html.link.Link;
import org.effrafax.underground.web.order.creation.OrderCreationPage;

public class OrderCreationLink extends Link<Void>
{
	private static final long serialVersionUID = 37;

	public OrderCreationLink(String id)
	{
		super(id);
	}

	@Override
	public void onClick()
	{
		setResponsePage(OrderCreationPage.class);
	}
}
