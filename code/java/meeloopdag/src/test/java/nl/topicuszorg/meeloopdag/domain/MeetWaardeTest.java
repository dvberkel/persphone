package nl.topicuszorg.meeloopdag.domain;

import static nl.topicuszorg.meeloopdag.domain.Meetwaarde.meetwaarde;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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
}
