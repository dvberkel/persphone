package nl.topicuszorg.meeloopdag.web.bmi.invoer.converter;

import static nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid.gram;
import nl.topicuszorg.meeloopdag.domain.meting.Meting;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid;
import nl.topicuszorg.meeloopdag.web.bmi.invoer.converter.controle.InputControle;

public class GewichtMetingConverter extends AbstractMetingConverter
{
	private static final long serialVersionUID = 37L;

	public GewichtMetingConverter()
	{
		super();
	}

	public GewichtMetingConverter(InputControle inputControle)
	{
		super(inputControle);
	}

	@Override
	protected Eenheid eenheid()
	{
		return gram();
	}

	@Override
	protected Class<?> getTargetType()
	{
		return Meting.class;
	}

}
