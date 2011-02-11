package org.effrafax.underground.web.order.overview.panel;

import org.effrafax.underground.util.test.UndergroundWicketTest;
import org.effrafax.underground.web.order.OrderCreationPage;
import org.effrafax.underground.web.order.overview.panel.component.OrderCreationLink;
import org.junit.Test;

public class OrderOverviewPanelTest extends UndergroundWicketTest
{
	@Test
	public void shouldRenderCorrectly()
	{
		getTester().startPanel(OrderOverviewPanel.class);
		getTester().assertNoErrorMessage();
		getTester().assertNoInfoMessage();
	}

	@Test
	public void shouldHaveAnOrderCreationLink()
	{
		getTester().startPanel(OrderOverviewPanel.class);
		getTester().assertComponent("panel:orderCreationLink", OrderCreationLink.class);
	}

	@Test
	public void orderCreationLinkShouldLinkToOrderCreationPage()
	{
		getTester().startPanel(OrderOverviewPanel.class);
		getTester().clickLink("panel:orderCreationLink");
		getTester().assertRenderedPage(OrderCreationPage.class);
	}

	@Test
	public void shouldHaveAnOrdersPanel()
	{
		getTester().startPanel(OrderOverviewPanel.class);
		getTester().assertComponent("panel:ordersPanel", OrdersPanel.class);
	}
}
