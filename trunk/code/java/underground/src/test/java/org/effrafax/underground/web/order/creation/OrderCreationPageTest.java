package org.effrafax.underground.web.order.creation;

import org.effrafax.underground.util.test.UndergroundWicketTest;
import org.effrafax.underground.web.order.creation.panel.OrderCreationPanel;
import org.junit.Test;

public class OrderCreationPageTest extends UndergroundWicketTest
{
	@Test
	public void shouldRenderCorrectly()
	{
		getTester().startPage(OrderCreationPage.class);
		getTester().assertRenderedPage(OrderCreationPage.class);
	}

	@Test
	public void shouldHaveAOrderCreationPanel()
	{
		getTester().startPage(OrderCreationPage.class);

		getTester().assertComponent("orderCreationPanel", OrderCreationPanel.class);
	}
}
