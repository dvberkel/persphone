package org.effrafax.underground.web.order.creation.panel.component.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class LocalDateConverterTest
{
	private LocalDateConverter localDateConverter;

	@Before
	public void createLocalDateConverter()
	{
		localDateConverter = new LocalDateConverter();
	}

	@Test
	public void shouldBeAbleToCreateALocalDateConverter()
	{
		assertNotNull(localDateConverter);
	}

	@Test
	public void shouldParseADateCorrectly()
	{
		LocalDate expectLocalDate = new LocalDate(2011, 1, 22);
		assertEquals(expectLocalDate, localDateConverter.convertToObject("22-1-2011", null));
	}

	@Test
	public void shouldRepresentADateCorrectly()
	{
		assertEquals("22-1-2011", localDateConverter.convertToString(new LocalDate(2011, 1, 22), null));
	}
}
