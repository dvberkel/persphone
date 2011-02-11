package org.effrafax.underground.web.order.overview;

import org.apache.wicket.markup.html.WebPage;
import org.effrafax.underground.web.order.overview.panel.OrderOverviewPanel;

public class OrderOverviewPage extends WebPage
{
	public OrderOverviewPage()
	{
		super();
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		add(new OrderOverviewPanel("orderOverviewPanel"));
	}

}
