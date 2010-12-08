package nl.topicuszorg.meeloopdag.web.bmi.invoer;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.util.convert.IConverter;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class AbstractMetingInvoerVeld extends TextField<Integer>
{

	private static final long serialVersionUID = 37L;

	public AbstractMetingInvoerVeld(String id)
	{
		super(id, Integer.class);
		setRequired(true);
	}

	@Override
	public IConverter getConverter(Class<?> type)
	{
		throw new NotImplementedException();
	}

}