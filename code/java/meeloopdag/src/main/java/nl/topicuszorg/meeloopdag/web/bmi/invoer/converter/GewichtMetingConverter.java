package nl.topicuszorg.meeloopdag.web.bmi.invoer.converter;

import static nl.topicuszorg.meeloopdag.domain.eenheid.Eenheid.gram;
import nl.topicuszorg.meeloopdag.domain.eenheid.Eenheid;

public class GewichtMetingConverter extends AbstractMetingConverter
{
	private static final long serialVersionUID = 1L;

	@Override
	protected Eenheid eenheid()
	{
		return gram();
	}

}
