package org.effrafax.underground.web.order.panel.component.converter;

import java.util.Locale;

import org.apache.wicket.util.convert.converters.AbstractConverter;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

public class LocalDateConverter extends AbstractConverter
{
	private static final long serialVersionUID = 37L;

	private DateTimeFormatter dateTimeFormatter;

	public LocalDateConverter()
	{
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
		builder.appendDayOfMonth(1).appendLiteral("-");
		builder.appendMonthOfYear(1).appendLiteral("-");
		builder.appendYear(4, 4);
		dateTimeFormatter = builder.toFormatter();
	}

	@Override
	protected Class<?> getTargetType()
	{
		return LocalDate.class;
	}

	@Override
	public Object convertToObject(String value, Locale locale)
	{
		return dateTimeFormatter.parseDateTime(value).toLocalDate();
	}

	@Override
	public String convertToString(Object value, Locale locale)
	{
		return dateTimeFormatter.print(((LocalDate) value).toDateTimeAtStartOfDay());
	}
}
