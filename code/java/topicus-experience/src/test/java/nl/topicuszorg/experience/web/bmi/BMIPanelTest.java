package nl.topicuszorg.experience.web.bmi;

import static org.junit.Assert.assertNotNull;
import nl.topicuszorg.experience.web.bmi.BMIPanel.BMIForm;
import nl.topicuszorg.experience.web.bmi.invoer.MetingInvoerPanel;

import org.apache.wicket.markup.html.basic.Label;
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
		tester.startPanel(BMIPanel.class);
	}

	@Test
	public void testerKanAangemaaktWorden()
	{
		assertNotNull(tester);
	}

	@Test
	public void zijnAlleComponentenAanwezig()
	{
		tester.assertNoErrorMessage();
		tester.assertNoInfoMessage();

		tester.assertComponent("panel:bmiform", BMIForm.class);
		tester.assertComponent("panel:bmiform:gewichtMeting", MetingInvoerPanel.class);
		tester.assertComponent("panel:bmiform:lengteMeting", MetingInvoerPanel.class);
		tester.assertComponent("panel:bmiform:bmi", Label.class);
	}

	@Test
	public void zijnDeInvoerVeldenVerplicht()
	{
		tester.assertRequired("panel:bmiform:gewichtMeting");
		tester.assertRequired("panel:bmiform:lengteMeting");
	}
}
