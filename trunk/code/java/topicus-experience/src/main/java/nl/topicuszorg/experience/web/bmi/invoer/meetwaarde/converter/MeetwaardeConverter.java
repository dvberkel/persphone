package nl.topicuszorg.experience.web.bmi.invoer.meetwaarde.converter;

import static nl.topicuszorg.experience.domain.meting.meetwaarde.Meetwaarde.meetwaarde;

import java.math.BigDecimal;
import java.util.Locale;

import nl.topicuszorg.experience.domain.meting.meetwaarde.Meetwaarde;
import nl.topicuszorg.experience.web.bmi.invoer.meetwaarde.converter.controle.GeheelGetalControle;
import nl.topicuszorg.experience.web.bmi.invoer.meetwaarde.converter.controle.InputControle;

import org.apache.wicket.util.convert.converters.AbstractConverter;

public class MeetwaardeConverter extends AbstractConverter
{
	private static final long serialVersionUID = 37L;

	private final InputControle inputControle;

	public MeetwaardeConverter()
	{
		this(new GeheelGetalControle());
	}

	public MeetwaardeConverter(InputControle inputControle)
	{
		if (inputControle == null)
		{
			throw new IllegalArgumentException("inputControle mag niet null zijn.");
		}
		this.inputControle = inputControle;
	}

	@Override
	protected Class<?> getTargetType()
	{
		return Meetwaarde.class;
	}

	@Override
	public Object convertToObject(String value, Locale locale)
	{
		if (getInputControle().correcteInput(value))
		{
			return meetwaarde(new BigDecimal(value));
		}
		else
		{
			throw newConversionException("geen correcte input", value, null);
		}
	}

	private InputControle getInputControle()
	{
		return inputControle;
	}
}
