package nl.topicuszorg.experience.web.bmi.invoer.meetwaarde;

import nl.topicuszorg.experience.domain.meting.meetwaarde.Meetwaarde;
import nl.topicuszorg.experience.web.bmi.invoer.meetwaarde.converter.MeetwaardeConverter;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.convert.IConverter;

public class MeetwaardeInvoerVeld extends TextField<Meetwaarde>
{
	private static final long serialVersionUID = 37L;

	public MeetwaardeInvoerVeld(String id)
	{
		super(id);
		init();
	}

	public MeetwaardeInvoerVeld(String id, IModel<Meetwaarde> meetwaardeModel)
	{
		super(id, meetwaardeModel);
		init();
	}

	private void init()
	{
		setRequired(true);
	}

	@Override
	public IConverter getConverter(Class<?> type)
	{
		return new MeetwaardeConverter();
	}
}
