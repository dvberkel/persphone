package org.effrafax.underground.web.order.overview.panel.component.datatable.column;

import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.ResourceModel;
import org.effrafax.underground.domain.model.Order;

public class OrderDateColumn extends PropertyColumn<Order>
{
	private static final long serialVersionUID = 1L;

	public OrderDateColumn()
	{
		super(new ResourceModel("orderDateHeader"), "orderDate");
	}
}
