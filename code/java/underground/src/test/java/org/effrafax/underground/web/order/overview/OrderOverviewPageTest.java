package org.effrafax.underground.web.order.overview;

import org.effrafax.underground.util.test.UndergroundWicketTest;
import org.effrafax.underground.web.order.overview.panel.OrderOverviewPanel;
import org.junit.Test;

public class OrderOverviewPageTest extends UndergroundWicketTest
{
	@Test
	public void shouldRenderCorrectly()
	{
		getTester().startPage(OrderOverviewPage.class);
		getTester().assertRenderedPage(OrderOverviewPage.class);
	}

	@Test
	public void shouldHaveAnOrderOverviewPanel()
	{
		getTester().startPage(OrderOverviewPage.class);

		getTester().assertComponent("orderOverviewPanel", OrderOverviewPanel.class);
	}
}
