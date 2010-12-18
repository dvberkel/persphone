package nl.topicuszorg.meeloopdag.web.bmi.invoer;

import nl.topicuszorg.meeloopdag.web.BMIPage;
import nl.topicuszorg.meeloopdag.web.bmi.BMIPanel;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class BMIPageTest
{
	private WicketTester tester;

	@Before
	public void maakEenWicketTester()
	{
		tester = new WicketTester();
	}

	@Test
	public void testRenderMyPage()
	{
		tester.startPage(BMIPage.class);
		tester.assertRenderedPage(BMIPage.class);
		tester.assertComponent("bmipanel", BMIPanel.class);
	}
}
