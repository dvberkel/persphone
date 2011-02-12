package org.effrafax.underground.web.order.creation.panel;

import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.effrafax.underground.web.order.creation.panel.form.OrderCreationForm;

public class OrderCreationPanel extends Panel
{
	private static final long serialVersionUID = 37L;

	public OrderCreationPanel(String id)
	{
		super(id);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		add(new FeedbackPanel("feedbackpanel"));
		add(new OrderCreationForm("orderCreationForm"));
	}
}
