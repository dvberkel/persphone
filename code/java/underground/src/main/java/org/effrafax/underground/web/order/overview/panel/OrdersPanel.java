package org.effrafax.underground.web.order.overview.panel;

import java.util.ArrayList;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.effrafax.underground.domain.model.Order;
import org.effrafax.underground.web.order.overview.panel.component.OrderListView;

public class OrdersPanel extends Panel
{
	private static final long serialVersionUID = 37L;

	public OrdersPanel(String id)
	{
		super(id);
	}

	public OrdersPanel(String id, IModel<?> model)
	{
		super(id, model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		add(new OrderListView("orders", new ArrayList<Order>()));
	}
}
