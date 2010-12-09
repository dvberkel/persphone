package nl.topicuszorg.meeloopdag.web.bmi.invoer.converter;

import static nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid.meter;
import nl.topicuszorg.meeloopdag.domain.meting.Meting;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid;

public class LengteMetingConverter extends AbstractMetingConverter
{
	private static final long serialVersionUID = 37L;

	@Override
	protected Eenheid eenheid()
	{
		return meter();
	}

	@Override
	protected Class<?> getTargetType()
	{
		return Meting.class;
	}

}
