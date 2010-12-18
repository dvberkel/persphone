package nl.topicuszorg.meeloopdag.web.bmi;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class BMIPanelTest
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
		tester.startPanel(BMIPanel.class);
		tester.assertNoErrorMessage();
	}
}
