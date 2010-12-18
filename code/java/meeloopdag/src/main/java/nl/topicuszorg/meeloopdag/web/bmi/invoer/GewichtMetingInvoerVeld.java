package nl.topicuszorg.meeloopdag.web.bmi.invoer;

import static nl.topicuszorg.meeloopdag.domain.meting.Meting.meting;
import static nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid.gram;
import nl.topicuszorg.meeloopdag.domain.meting.Meting;
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
	protected Meting<Gram> getMinimumMeting()
	{
		return meting(0, gram());
	}

	@Override
	public IConverter getConverter(Class<?> type)
	{
		return new GewichtMetingConverter();
	}
}
