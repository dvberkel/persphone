package org.effrafax.underground.web.order.overview.panel;

import java.util.Collections;

import org.effrafax.underground.util.test.UndergroundWicketTest;
import org.junit.Test;

public class OrdersPanelTest extends UndergroundWicketTest
{
	@Test
	public void shouldRenderCorrectly()
	{
		getTester().startPanel(OrdersPanel.class);
		getTester().assertNoErrorMessage();
		getTester().assertNoInfoMessage();
	}

	@Test
	public void shouldHaveAOrdersTable()
	{
		getTester().startPanel(OrdersPanel.class);
		getTester().assertListView("panel:orders", Collections.emptyList());
	}
}
