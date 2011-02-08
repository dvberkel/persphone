package org.effrafax.underground.web.order.panel.component;

import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.effrafax.underground.domain.Order;
import org.joda.time.LocalDate;

public class OrderInputComponent extends FormComponentPanel<Order>
{
	private static final long serialVersionUID = 37L;

	private LocalDateField localDateField;

	private LocalDate orderDate = new LocalDate();

	public OrderInputComponent(String id)
	{
		super(id);
	}

	public OrderInputComponent(String id, IModel<Order> orderModel)
	{
		super(id, orderModel);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		localDateField = new LocalDateField("orderDate", new PropertyModel<LocalDate>(this, "orderDate"));
		localDateField.setRequired(true);
		add(localDateField);
	}

	@Override
	protected void convertInput()
	{
		setConvertedInput(Order.create(localDateField.getConvertedInput()));
	}

	@Override
	protected void onBeforeRender()
	{
		Order order = getModelObject();
		if (order != null)
		{
			orderDate = order.getOrderDate();
		}
		super.onBeforeRender();

	}

}
