package org.effrafax.underground.web.order.panel.component.converter;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

public class LocalTimeConverter extends AbstractDateTimeConverter<LocalTime>
{
	private static final long serialVersionUID = 37L;

	public LocalTimeConverter()
	{
		super();
	}

	@Override
	protected Class<? extends LocalTime> getTargetType()
	{
		return LocalTime.class;
	}

	@Override
	protected DateTimeFormatter createDateTimeFormatter()
	{
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
		builder.appendClockhourOfDay(1);
		builder.appendLiteral(":");
		builder.appendMinuteOfHour(1);
		return builder.toFormatter();
	}

	@Override
	protected LocalTime convertFromDateTime(DateTime parsedDateTime)
	{
		return parsedDateTime.toLocalTime();
	}

	@Override
	protected DateTime convertToDateTime(LocalTime value)
	{
		return value.toDateTimeToday();
	}

}
