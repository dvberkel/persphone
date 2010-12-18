package nl.topicuszorg.meeloopdag.web.bmi.invoer;

import nl.topicuszorg.meeloopdag.domain.meting.Meting;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.util.convert.IConverter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class AbstractMetingInvoerVeld<T extends Eenheid> extends TextField<Meting<T>>
{

	private static final long serialVersionUID = 37L;

	public AbstractMetingInvoerVeld(String id)
	{
		super(id);
		setRequired(true);
	}

	@Override
	public IConverter getConverter(Class<?> type)
	{
		throw new NotImplementedException();
	}

}