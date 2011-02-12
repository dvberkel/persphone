package org.effrafax.underground.web.order.creation.panel.component;

import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;
import org.effrafax.underground.domain.model.Order;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class OrderInputComponent extends FormComponentPanel<Order>
{
	private static final long serialVersionUID = 37L;

	private LocalDateField orderDateField;

	@SuppressWarnings("unused")
	private LocalDate orderDate = new LocalDate();

	private LocalTimeField closingTimeField;

	@SuppressWarnings("unused")
	private LocalTime closingTime = new LocalTime(10, 15);

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
		orderDateField = new LocalDateField("orderDate", new PropertyModel<LocalDate>(this, "orderDate"));
		orderDateField.setRequired(true);
		orderDateField.setLabel(new ResourceModel("orderDateKey"));
		add(orderDateField);
		closingTimeField = new LocalTimeField("closingTime", new PropertyModel<LocalTime>(this, "closingTime"));
		closingTimeField.setRequired(true);
		closingTimeField.setLabel(new ResourceModel("closingTimeKey"));
		add(closingTimeField);
	}

	@Override
	protected void convertInput()
	{
		setConvertedInput(Order.create(orderDateField.getConvertedInput(), closingTimeField.getConvertedInput()));
	}

	@Override
	protected void onBeforeRender()
	{
		Order order = getModelObject();
		if (order != null)
		{
			orderDate = order.getOrderDate();
			closingTime = order.getClosingTime();
		}
		super.onBeforeRender();

	}

}
