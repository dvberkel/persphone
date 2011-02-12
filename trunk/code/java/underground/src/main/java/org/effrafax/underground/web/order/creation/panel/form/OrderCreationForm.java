package org.effrafax.underground.web.order.creation.panel.form;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.PropertyModel;
import org.effrafax.underground.domain.model.Order;
import org.effrafax.underground.web.order.creation.panel.component.OrderInputComponent;
import org.effrafax.underground.web.order.overview.OrderOverviewPage;

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

	@Override
	protected void onSubmit()
	{
		saveOrder();
		setResponsePage(OrderOverviewPage.class);
	}

	private void saveOrder()
	{
		// Save Order
	}

}
