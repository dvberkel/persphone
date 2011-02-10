package org.effrafax.underground.web.order.panel.form;

import static org.junit.Assert.assertNotNull;

import org.apache.wicket.util.tester.FormTester;
import org.effrafax.underground.util.test.UndergroundWicketTest;
import org.effrafax.underground.web.order.panel.OrderCreationPanel;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class OrderCreationFormTest extends UndergroundWicketTest
{
	private FormTester formTester;

	@Before
	public void createFormTester()
	{
		getTester().startPanel(OrderCreationPanel.class);
		formTester = getTester().newFormTester("panel:orderCreationForm");
	}

	@Test
	public void shouldBeAbleToCreateAFormTester()
	{
		assertNotNull(formTester);
	}

	@Test
	public void orderDateShouldBeRequired()
	{
		formTester.setValue("orderInputComponent:orderDate", "");
		formTester.submit();

		getTester().assertErrorMessages(new String[] { "order date is required." });
	}

	@Test
	public void closingTimeShouldBeRequired()
	{
		formTester.setValue("orderInputComponent:closingTime", "");
		formTester.submit();

		getTester().assertErrorMessages(new String[] { "closing time is required." });
	}

	@Ignore
	@Test
	public void incorrectOrderShouldProduceAFeedbackMessage()
	{
		String inputDate = "Not a date";
		formTester.setValue("orderInputComponent:orderDate", inputDate);
		formTester.setValue("orderInputComponent:closingTime", "10:15");
		formTester.submit();

		getTester().assertErrorMessages(new String[] { String.format("%s is not a valid order date", inputDate) });
	}
}
