package org.effrafax.underground.web.order.overview.panel;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.effrafax.underground.domain.model.Order;
import org.effrafax.underground.web.order.overview.panel.component.OrderListView;
import org.effrafax.underground.web.order.overview.panel.component.datatable.OrderDataTable;
import org.effrafax.underground.web.order.overview.panel.component.datatable.provider.OrderProvider;
import org.joda.time.LocalDate;

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
		add(new OrderDataTable("ordersTable", new OrderProvider(getOrders())));
	}

	private List<Order> getOrders()
	{
		LocalDate now = new LocalDate();
		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(Order.create(now));
		orders.add(Order.create(now.plusDays(1)));
		orders.add(Order.create(now.plusDays(2)));
		orders.add(Order.create(now.plusDays(3)));
		return orders;
	}
}
