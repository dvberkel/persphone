package nl.topicuszorg.meeloopdag.web.bmi.invoer.converter;

import static nl.topicuszorg.meeloopdag.domain.meting.Meting.meting;
import static nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid.meter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.wicket.util.convert.ConversionException;
import org.junit.Before;
import org.junit.Test;

public class LengteMetingConverterTest
{
	private LengteMetingConverter lengteMetingConverter;

	@Before
	public void maakLengteMetingConverter()
	{
		lengteMetingConverter = new LengteMetingConverter();
	}

	@Test
	public void lengteMetingConverterKanAangemaaktWorden()
	{
		assertNotNull(lengteMetingConverter);
	}

	@Test
	public void converterenNaarObjectLevertEenMetingOp()
	{
		assertEquals(meting(37, meter()), lengteMetingConverter.convertToObject("37", null));
	}

	@Test
	public void converterenNaarStringLevertGoedeRepresentatie()
	{
		assertEquals("51", lengteMetingConverter.convertToString(meting(51, meter()), null));
	}

	@Test(expected = ConversionException.class)
	public void hetConverterenVanIetsAndersDanEenGetalGooitEenExceptie()
	{
		lengteMetingConverter.convertToObject("een string", null);
	}
}
