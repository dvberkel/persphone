package org.effrafax.underground.web.order.creation.panel.component.converter;

import java.util.Locale;

import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.converters.AbstractConverter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

public abstract class AbstractDateTimeConverter<T> extends AbstractConverter
{
	private static final long serialVersionUID = 37L;

	private final DateTimeFormatter formatter;

	public AbstractDateTimeConverter()
	{
		formatter = createDateTimeFormatter();
	}

	@Override
	protected abstract Class<? extends T> getTargetType();

	protected abstract DateTimeFormatter createDateTimeFormatter();

	@Override
	public final Object convertToObject(String value, Locale locale)
	{
		DateTime parsedDateTime = null;
		try
		{
			parsedDateTime = formatter.parseDateTime(value);
		}
		catch (IllegalArgumentException e)
		{
			ConversionException conversionException = newConversionException("invalid input", value, locale);
			conversionException.setResourceKey(getResourceKey());
			throw conversionException;
		}
		return convertFromDateTime(parsedDateTime);
	}

	private String getResourceKey()
	{
		return this.getClass().getSimpleName();
	}

	protected abstract T convertFromDateTime(DateTime parsedDateTime);

	@Override
	public final String convertToString(Object value, Locale locale)
	{
		return formatter.print(convertToDateTime((T) value));
	}

	protected abstract DateTime convertToDateTime(T value);
}