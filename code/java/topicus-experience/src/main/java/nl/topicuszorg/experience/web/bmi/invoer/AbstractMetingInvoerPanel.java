package nl.topicuszorg.experience.web.bmi.invoer;

import static nl.topicuszorg.experience.domain.meting.Meting.meting;
import static nl.topicuszorg.experience.domain.meting.meetwaarde.Meetwaarde.meetwaarde;
import nl.topicuszorg.experience.domain.meting.Meting;
import nl.topicuszorg.experience.domain.meting.eenheid.Eenheid;
import nl.topicuszorg.experience.domain.meting.meetwaarde.Meetwaarde;
import nl.topicuszorg.experience.web.bmi.invoer.meetwaarde.MeetwaardeInvoerVeld;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public abstract class AbstractMetingInvoerPanel<T extends Eenheid> extends FormComponentPanel<Meting<T>>
{

	private static final long serialVersionUID = 37L;

	private Meetwaarde meetwaarde = meetwaarde(80000);

	private MeetwaardeInvoerVeld meetwaardeInvoerVeld;

	public AbstractMetingInvoerPanel(String id)
	{
		super(id);
	}

	public AbstractMetingInvoerPanel(String id, IModel<Meting<T>> model)
	{
		super(id, model);
	}

	protected void init()
	{
		setRequired(true);
		meetwaardeInvoerVeld = new MeetwaardeInvoerVeld("meetwaarde", new PropertyModel<Meetwaarde>(this, "meetwaarde"));
		add(meetwaardeInvoerVeld);
		add(new Label("eenheid", new Model<Eenheid>(getEenheid())));
	}

	@Override
	protected void convertInput()
	{
		setConvertedInput(meting(meetwaardeInvoerVeld.getConvertedInput(), getEenheid()));
	}

	protected abstract T getEenheid();
}