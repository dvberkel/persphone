package nl.topicuszorg.meeloopdag.domain.meting.meetwaarde;

import static nl.topicuszorg.meeloopdag.domain.meting.meetwaarde.Meetwaarde.meetwaarde;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;

import org.junit.Test;

public class MeetWaardeTest
{
	@Test
	public void meetwaardeKunnenAangemaaktWorden()
	{
		assertNotNull(meetwaarde(37));
	}

	@Test
	public void meetwaardeZijnGelijkBijGelijkeWaarden()
	{
		assertEquals(meetwaarde(37), meetwaarde(37));
	}

	@Test
	public void meetwaardeZijnOnGelijkBijOnGelijkeWaarden()
	{
		assertFalse(meetwaarde(37).equals(meetwaarde(51)));
	}

	@Test
	public void meetwaardeKunnenVermenigvuldigdWorden()
	{
		assertEquals(meetwaarde(6), meetwaarde(2).maal(meetwaarde(3)));
	}

	@Test
	public void meetwaardeHebbenZinnigeToString()
	{
		assertEquals("37", meetwaarde(37).toString());
	}

	@Test
	public void meetwaardenZijnSerialiseerbaar()
	{
		assertTrue(meetwaarde(37) instanceof Serializable);
	}
}