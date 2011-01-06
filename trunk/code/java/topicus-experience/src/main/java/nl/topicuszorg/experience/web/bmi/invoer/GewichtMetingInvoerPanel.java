package nl.topicuszorg.experience.web.bmi.invoer;

import static nl.topicuszorg.experience.domain.meting.Meting.meting;
import static nl.topicuszorg.experience.domain.meting.eenheid.Eenheid.gram;
import static nl.topicuszorg.experience.domain.meting.meetwaarde.Meetwaarde.meetwaarde;
import nl.topicuszorg.experience.domain.meting.Meting;
import nl.topicuszorg.experience.domain.meting.eenheid.Gram;
import nl.topicuszorg.experience.domain.meting.meetwaarde.Meetwaarde;
import nl.topicuszorg.experience.web.bmi.invoer.meetwaarde.MeetwaardeInvoerVeld;

import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.PropertyModel;

public class GewichtMetingInvoerPanel extends FormComponentPanel<Meting<Gram>>
{
	private static final long serialVersionUID = 37L;

	private Meetwaarde meetwaarde = meetwaarde(80000);

	private MeetwaardeInvoerVeld meetwaardeInvoerVeld;

	public GewichtMetingInvoerPanel(String id)
	{
		super(id);
		init();
	}

	private void init()
	{
		setRequired(true);
		meetwaardeInvoerVeld = new MeetwaardeInvoerVeld("meetwaarde", new PropertyModel<Meetwaarde>(this, "meetwaarde"));
		add(meetwaardeInvoerVeld);
	}

	@Override
	protected void convertInput()
	{
		setConvertedInput(meting(meetwaardeInvoerVeld.getConvertedInput(), gram()));
	}

}
