package org.effrafax.underground.web.order.panel.component.converter;

import java.util.Locale;

import org.apache.wicket.util.convert.converters.AbstractConverter;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormatter;

public abstract class AbstractDateTimeConverter extends AbstractConverter
{
	private static final long serialVersionUID = 37L;

	private final DateTimeFormatter formatter;

	public AbstractDateTimeConverter()
	{
		formatter = createDateTimeFormatter();
	}

	protected abstract DateTimeFormatter createDateTimeFormatter();

	@Override
	public Object convertToObject(String value, Locale locale)
	{
		return formatter.parseDateTime(value).toLocalTime();
	}

	@Override
	public String convertToString(Object value, Locale locale)
	{
		return formatter.print(((LocalTime) value).toDateTimeToday());
	}

}