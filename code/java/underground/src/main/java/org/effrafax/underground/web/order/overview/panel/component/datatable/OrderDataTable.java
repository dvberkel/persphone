package org.effrafax.underground.web.order.overview.panel.component.datatable;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.effrafax.underground.domain.model.Order;
import org.effrafax.underground.web.order.overview.panel.component.datatable.column.OrderDateColumn;

public class OrderDataTable extends DataTable<Order>
{
	private static final long serialVersionUID = 37L;

	public OrderDataTable(String id, IDataProvider<Order> dataProvider, int rowsPerPage)
	{
		super(id, getColums(), dataProvider, rowsPerPage);
	}

	public OrderDataTable(String id, IDataProvider<Order> dataProvider)
	{
		this(id, dataProvider, 10);
	}

	private static IColumn<Order>[] getColums()
	{
		List<IColumn<Order>> columns = new ArrayList<IColumn<Order>>();
		columns.add(new OrderDateColumn());
		return columns.toArray(prototypeOrderColumnArray());
	}

	@SuppressWarnings("unchecked")
	private static IColumn<Order>[] prototypeOrderColumnArray()
	{
		return (IColumn<Order>[]) new IColumn[0];
	}
}
