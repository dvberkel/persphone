package nl.topicuszorg.meeloopdag.web.bmi.invoer;

import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Gram;
import nl.topicuszorg.meeloopdag.web.bmi.invoer.converter.GewichtMetingConverter;

import org.apache.wicket.util.convert.IConverter;

public class GewichtMetingInvoerVeld extends AbstractMetingInvoerVeld<Gram>
{
	private static final long serialVersionUID = 37L;

	public GewichtMetingInvoerVeld(String id)
	{
		super(id);
	}

	@Override
	public IConverter getConverter(Class<?> type)
	{
		return new GewichtMetingConverter();
	}
}
