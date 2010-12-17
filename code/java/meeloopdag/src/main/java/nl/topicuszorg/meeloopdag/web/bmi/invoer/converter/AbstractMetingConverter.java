package nl.topicuszorg.meeloopdag.web.bmi.invoer.converter;

import static nl.topicuszorg.meeloopdag.domain.meting.Meting.meting;

import java.util.Locale;

import nl.topicuszorg.meeloopdag.domain.meting.Meting;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid;
import nl.topicuszorg.meeloopdag.web.bmi.invoer.converter.controle.GeheelGetalControle;
import nl.topicuszorg.meeloopdag.web.bmi.invoer.converter.controle.InputControle;

import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.convert.converters.AbstractConverter;

public abstract class AbstractMetingConverter extends AbstractConverter implements IConverter
{
	private static final long serialVersionUID = 37L;

	private InputControle inputControle = new GeheelGetalControle();;

	public AbstractMetingConverter()
	{
		this(new GeheelGetalControle());
	}

	public AbstractMetingConverter(InputControle inputControle)
	{
		this.inputControle = inputControle;
	}

	@Override
	public Object convertToObject(String value, Locale locale)
	{
		if (getControle().correcteInput(value))
		{
			return meting(Integer.valueOf(value), eenheid());
		}
		else
		{
			throw newConversionException("geen correcte input", value, null);
		}
	}

	private InputControle getControle()
	{
		return inputControle;
	}

	protected abstract Eenheid eenheid();

	@Override
	public String convertToString(Object value, Locale locale)
	{
		return ((Meting<?>) value).getMeetwaarde().toString();
	}

}
