package nl.topicuszorg.experience.web.bmi.invoer;

import static nl.topicuszorg.experience.domain.meting.Meting.meting;
import static nl.topicuszorg.experience.domain.meting.meetwaarde.Meetwaarde.meetwaarde;
import nl.topicuszorg.experience.domain.meting.Meting;
import nl.topicuszorg.experience.domain.meting.eenheid.Eenheid;
import nl.topicuszorg.experience.domain.meting.meetwaarde.Meetwaarde;
import nl.topicuszorg.experience.web.bmi.invoer.meetwaarde.MeetwaardeInvoerVeld;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class MetingInvoerPanel<T extends Eenheid> extends FormComponentPanel<Meting<T>>
{

	private static final long serialVersionUID = 37L;

	private Meetwaarde meetwaarde = meetwaarde(80000);

	private T eenheid;

	private MeetwaardeInvoerVeld meetwaardeInvoerVeld;

	public MetingInvoerPanel(String id, T eenheid)
	{
		super(id);
		setRequired(true);
		this.eenheid = eenheid;

		meetwaardeInvoerVeld = new MeetwaardeInvoerVeld("meetwaarde", new PropertyModel<Meetwaarde>(this, "meetwaarde"));
		add(meetwaardeInvoerVeld);
		add(new Label("eenheid", new Model<Eenheid>(getEenheid())));
	}

	@Override
	protected void convertInput()
	{
		setConvertedInput(meting(meetwaardeInvoerVeld.getConvertedInput(), getEenheid()));
	}

	protected T getEenheid()
	{
		return eenheid;
	}
}