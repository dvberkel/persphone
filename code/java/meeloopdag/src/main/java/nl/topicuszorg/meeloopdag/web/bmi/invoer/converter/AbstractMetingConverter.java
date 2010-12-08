package nl.topicuszorg.meeloopdag.web.bmi.invoer.converter;

import static nl.topicuszorg.meeloopdag.domain.meting.Meting.meting;

import java.util.Locale;

import nl.topicuszorg.meeloopdag.domain.meting.Meting;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid;

import org.apache.wicket.util.convert.IConverter;

public abstract class AbstractMetingConverter implements IConverter
{
	private static final long serialVersionUID = 37L;

	@Override
	public Object convertToObject(String value, Locale locale)
	{
		return meting(Integer.valueOf(value), eenheid());
	}

	protected abstract Eenheid eenheid();

	@Override
	public String convertToString(Object value, Locale locale)
	{
		return ((Meting<?>) value).getMeting().toString();
	}

}
