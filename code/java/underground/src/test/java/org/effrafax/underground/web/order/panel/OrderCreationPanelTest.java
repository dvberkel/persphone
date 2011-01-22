package org.effrafax.underground.web.order.panel;

import static org.junit.Assert.assertNotNull;

import org.apache.wicket.util.tester.WicketTester;
import org.effrafax.underground.web.order.panel.component.OrderInputComponent;
import org.junit.Before;
import org.junit.Test;

public class OrderCreationPanelTest
{
	private WicketTester tester;

	@Before
	public void createWicketTester()
	{
		tester = new WicketTester();
	}

	@Test
	public void shouldCreateAWicketTester()
	{
		assertNotNull(tester);
	}

	@Test
	public void shouldRenderCorrectly()
	{
		tester.startPanel(OrderCreationPanel.class);
		tester.assertNoErrorMessage();
		tester.assertNoInfoMessage();
	}

	@Test
	public void shouldHaveAnOrderInputComponent()
	{
		tester.startPanel(OrderCreationPanel.class);
		tester.assertComponent("panel:orderInputComponent", OrderInputComponent.class);
	}
}
