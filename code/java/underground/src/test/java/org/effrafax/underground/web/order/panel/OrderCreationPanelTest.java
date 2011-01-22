package org.effrafax.underground.web.order.panel;


import org.effrafax.underground.util.test.UndergroundWicketTest;
import org.effrafax.underground.web.order.panel.component.OrderInputComponent;
import org.junit.Test;

public class OrderCreationPanelTest extends UndergroundWicketTest
{
	@Test
	public void shouldRenderCorrectly()
	{
		getTester().startPanel(OrderCreationPanel.class);
		getTester().assertNoErrorMessage();
		getTester().assertNoInfoMessage();
	}

	@Test
	public void shouldHaveAnOrderInputComponent()
	{
		getTester().startPanel(OrderCreationPanel.class);
		getTester().assertComponent("panel:orderInputComponent", OrderInputComponent.class);
	}
}
