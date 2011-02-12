package org.effrafax.underground.web.order.creation.panel.form;

import static org.junit.Assert.assertNotNull;

import org.apache.wicket.util.tester.FormTester;
import org.effrafax.underground.util.test.UndergroundWicketTest;
import org.effrafax.underground.web.order.overview.OrderOverviewPage;
import org.effrafax.underground.web.order.panel.OrderCreationPanel;
import org.junit.Before;
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

	@Test
	public void incorrectOrderDateShouldProduceAFeedbackMessage()
	{
		String inputDate = "Not a date";
		formTester.setValue("orderInputComponent:orderDate", inputDate);
		formTester.setValue("orderInputComponent:closingTime", "10:15");
		formTester.submit();

		getTester().assertErrorMessages(new String[] { String.format("'%s' is not a valid order date", inputDate) });
	}

	@Test
	public void incorrectClosingTimeShouldProduceAFeedbackMessage()
	{
		String inputTime = "Not a time";
		formTester.setValue("orderInputComponent:orderDate", "10-02-2011");
		formTester.setValue("orderInputComponent:closingTime", inputTime);
		formTester.submit();

		getTester().assertErrorMessages(new String[] { String.format("'%s' is not a valid closing time", inputTime) });
	}

	@Test
	public void correctInputShouldLeadToOrderOverviewPage()
	{
		String inputTime = "Not a time";
		formTester.setValue("orderInputComponent:orderDate", "11-02-2011");
		formTester.setValue("orderInputComponent:closingTime", "10:15");
		formTester.submit();

		getTester().assertRenderedPage(OrderOverviewPage.class);
	}
}
