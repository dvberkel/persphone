package org.effrafax.underground.web.order.overview.panel.component;

import java.util.List;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.effrafax.underground.domain.model.Order;

public class OrderListView extends ListView<Order>
{
	private static final long serialVersionUID = 37L;

	public OrderListView(String id, List<? extends Order> list)
	{
		super(id, list);
	}

	@Override
	protected void populateItem(ListItem<Order> item)
	{
	}

}
