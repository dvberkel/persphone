package org.effrafax.underground.web.order.panel.component;

import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.IModel;
import org.effrafax.underground.domain.Order;

public class OrderInputComponent extends FormComponentPanel<Order>
{
	private static final long serialVersionUID = 37L;

	public OrderInputComponent(String id)
	{
		super(id);
	}

	public OrderInputComponent(String id, IModel<Order> orderModel)
	{
		super(id, orderModel);
	}

}
