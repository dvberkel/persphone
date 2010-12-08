package nl.topicuszorg.meeloopdag.web.bmi;

import nl.topicuszorg.meeloopdag.web.bmi.invoer.GewichtMetingInvoerVeld;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;

public class BMIPanel extends Panel
{
	private static final long serialVersionUID = 37L;

	public BMIPanel(String id)
	{
		super(id);
		add(new BMIForm("bmiform"));
	}

	class BMIForm extends Form<Void>
	{
		private static final long serialVersionUID = 37L;

		public BMIForm(String id)
		{
			super(id);
			add(new GewichtMetingInvoerVeld("gewichtmeting"));
		}

	}
}
