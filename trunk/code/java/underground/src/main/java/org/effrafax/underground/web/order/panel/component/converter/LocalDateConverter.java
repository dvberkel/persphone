package org.effrafax.underground.web.order.panel.component.converter;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

public class LocalDateConverter extends AbstractDateTimeConverter<LocalDate>
{
	private static final long serialVersionUID = 37L;

	public LocalDateConverter()
	{
		super();
	}

	@Override
	protected Class<LocalDate> getTargetType()
	{
		return LocalDate.class;
	}

	@Override
	protected DateTimeFormatter createDateTimeFormatter()
	{
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
		builder.appendDayOfMonth(1).appendLiteral("-");
		builder.appendMonthOfYear(1).appendLiteral("-");
		builder.appendYear(4, 4);
		return builder.toFormatter();
	}

	@Override
	protected LocalDate convertFromDateTime(DateTime parsedDateTime)
	{
		return parsedDateTime.toLocalDate();
	}

	@Override
	protected DateTime convertToDateTime(LocalDate value)
	{
		return value.toDateTimeAtStartOfDay();
	}
}
