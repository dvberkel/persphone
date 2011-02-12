package org.effrafax.underground.web.order.creation.panel.component.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

public class LocalTimeConverterTest
{
	private AbstractDateTimeConverter localTimeConverter;

	@Before
	public void createLocalTimeConverter()
	{
		localTimeConverter = new LocalTimeConverter();
	}

	@Test
	public void shouldBeAbleToConstructALocalTimeConverter()
	{
		assertNotNull(localTimeConverter);
	}

	@Test
	public void shouldParseTimeCorrectly()
	{
		LocalTime expectedLocalTime = new LocalTime(10, 15);
		assertEquals(expectedLocalTime, localTimeConverter.convertToObject("10:15", null));
	}

	@Test
	public void shouldRepresentTimeCorrectly()
	{
		assertEquals("10:15", localTimeConverter.convertToString(new LocalTime(10, 15), null));
	}
}
