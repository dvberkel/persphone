package org.effrafax.underground.web.order.overview.panel.component.datatable.provider;

import java.util.List;

import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.effrafax.underground.domain.model.Order;

public class OrderProvider extends ListDataProvider<Order> implements IDataProvider<Order>
{
	private static final long serialVersionUID = 1L;

	public OrderProvider(List<Order> orders)
	{
		super(orders);
	}
}
