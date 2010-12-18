package nl.topicuszorg.meeloopdag.web.bmi.invoer;

import nl.topicuszorg.meeloopdag.web.bmi.invoer.converter.LengteMetingConverter;
import nl.topicuszorg.meeloopdag.web.bmi.invoer.converter.controle.GebrokenGetalControle;

import org.apache.wicket.util.convert.IConverter;

public class LengteMetingInvoerVeld extends AbstractMetingInvoerVeld
{
	private static final long serialVersionUID = 37L;

	public LengteMetingInvoerVeld(String id)
	{
		super(id);
	}

	@Override
	public IConverter getConverter(Class<?> type)
	{
		return new LengteMetingConverter(new GebrokenGetalControle());
	}
}
