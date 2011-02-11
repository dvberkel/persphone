package org.effrafax.underground.web.order.overview.panel;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.effrafax.underground.web.order.overview.panel.component.OrderCreationLink;

public class OrderOverviewPanel extends Panel
{
	private static final long serialVersionUID = 37L;

	public OrderOverviewPanel(String id)
	{
		super(id);
	}

	public OrderOverviewPanel(String id, IModel<?> model)
	{
		super(id, model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		add(new OrderCreationLink("orderCreationLink"));
		add(new OrdersPanel("ordersPanel"));
	}

}
