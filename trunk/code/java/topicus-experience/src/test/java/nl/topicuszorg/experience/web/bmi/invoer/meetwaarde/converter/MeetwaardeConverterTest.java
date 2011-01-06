package nl.topicuszorg.experience.web.bmi.invoer.meetwaarde.converter;

import static nl.topicuszorg.experience.domain.meting.meetwaarde.Meetwaarde.meetwaarde;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import nl.topicuszorg.experience.web.bmi.invoer.converter.GewichtMetingConverter;
import nl.topicuszorg.experience.web.bmi.invoer.meetwaarde.converter.controle.GebrokenGetalControle;

import org.apache.wicket.util.convert.ConversionException;
import org.junit.Before;
import org.junit.Test;

public class MeetwaardeConverterTest
{
	private MeetwaardeConverter meetwaardeConverter;

	@Before
	public void maakGewichtMetingConverter()
	{
		meetwaardeConverter = new MeetwaardeConverter();
	}

	@Test
	public void gewichtMetingConverterKanAangemaaktWorden()
	{
		assertNotNull(meetwaardeConverter);
	}

	@Test
	public void converterenNaarObjectLevertEenMeetwaardeOp()
	{
		assertEquals(meetwaarde(37), meetwaardeConverter.convertToObject("37", null));
	}

	@Test
	public void converterenNaarStringLevertGoedeRepresentatie()
	{
		assertEquals("51", meetwaardeConverter.convertToString(meetwaarde(51), null));
	}

	@Test(expected = ConversionException.class)
	public void hetConverterenVanIetsAndersDanEenGetalGooitEenExceptie()
	{
		meetwaardeConverter.convertToObject("een string", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void gewichtMetingConverterKanNietAangemaaktWordenMetEenNullInputControle()
	{
		new GewichtMetingConverter(null);
	}

	@Test
	public void gewichtMetingConverterMetEenGebrokenGetallenConverterLevertEenMeetwaardeOp()
	{
		meetwaardeConverter = new MeetwaardeConverter(new GebrokenGetalControle());
		assertEquals(meetwaarde(1.85), meetwaardeConverter.convertToObject("1.85", null));
	}
}
