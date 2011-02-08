package org.effrafax.underground.web.order.panel.form;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import org.effrafax.underground.domain.Order;
import org.effrafax.underground.web.order.panel.component.OrderInputComponent;

public class OrderCreationForm extends Form<Order>
{
	private static final long serialVersionUID = 37L;

	private Order order = null;

	public OrderCreationForm(String id)
	{
		super(id);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		add(new OrderInputComponent("orderInputComponent", new PropertyModel<Order>(this, "order")));
	}

}
