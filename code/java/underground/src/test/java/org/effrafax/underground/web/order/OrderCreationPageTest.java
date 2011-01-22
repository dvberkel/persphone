package org.effrafax.underground.web.order;

import static org.junit.Assert.assertNotNull;

import org.apache.wicket.util.tester.WicketTester;
import org.effrafax.underground.web.order.panel.OrderCreationPanel;
import org.junit.Before;
import org.junit.Test;

public class OrderCreationPageTest
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
		tester.startPage(OrderCreationPage.class);
		tester.assertRenderedPage(OrderCreationPage.class);
	}

	@Test
	public void shouldHaveAOrderCreationPanel()
	{
		tester.startPage(OrderCreationPage.class);

		tester.assertComponent("orderCreationPanel", OrderCreationPanel.class);
	}
}
