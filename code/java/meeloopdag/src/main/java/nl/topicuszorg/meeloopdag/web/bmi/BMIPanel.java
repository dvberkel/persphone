package nl.topicuszorg.meeloopdag.web.bmi;

import static nl.topicuszorg.meeloopdag.domain.meting.Meting.meting;
import static nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid.gram;
import static nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid.meter;
import nl.topicuszorg.meeloopdag.domain.meting.Meting;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Gram;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Meter;
import nl.topicuszorg.meeloopdag.web.bmi.invoer.GewichtMetingInvoerVeld;
import nl.topicuszorg.meeloopdag.web.bmi.invoer.LengteMetingInvoerVeld;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

public class BMIPanel extends Panel
{
	private static final long serialVersionUID = 37L;

	public BMIPanel(String id)
	{
		super(id);
		add(new BMIForm("bmiform"));
	}

	class BMIForm extends Form<BMIForm>
	{
		private static final long serialVersionUID = 37L;

		private Meting<Gram> gewichtMeting = meting(6500, gram());

		private Meting<Meter> lengteMeting = meting(1, meter());

		public BMIForm(String id)
		{
			super(id);
			setModel(new CompoundPropertyModel<BMIForm>(this));
			add(new FeedbackPanel("feedbackpanel"));
			add(new GewichtMetingInvoerVeld("gewichtMeting"));
			add(new LengteMetingInvoerVeld("lengteMeting"));
			add(new Label("bmi"));
		}

		public Meting<?> getBmi()
		{
			return gewichtMeting.maal(lengteMeting);
		}
	}
}
