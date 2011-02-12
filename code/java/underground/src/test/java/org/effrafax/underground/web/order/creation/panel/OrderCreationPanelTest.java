package org.effrafax.underground.web.order.creation.panel;

import org.effrafax.underground.util.test.UndergroundWicketTest;
import org.effrafax.underground.web.order.panel.OrderCreationPanel;
import org.effrafax.underground.web.order.panel.form.OrderCreationForm;
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
	public void shouldHaveAnOrderInputForm()
	{
		getTester().startPanel(OrderCreationPanel.class);
		getTester().assertComponent("panel:orderCreationForm", OrderCreationForm.class);
	}
}
