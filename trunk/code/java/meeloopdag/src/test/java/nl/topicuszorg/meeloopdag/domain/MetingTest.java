package nl.topicuszorg.meeloopdag.domain;

import static nl.topicuszorg.meeloopdag.domain.Eenheid.gram;
import static nl.topicuszorg.meeloopdag.domain.Eenheid.meter;
import static nl.topicuszorg.meeloopdag.domain.Meting.meting;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MetingTest
{
	@Test
	public void metingKanWordenAangemaakt()
	{
		assertNotNull(meting(37, gram()));
	}

	@Test
	public void metingZijnGelijkBijGelijkeWaardeEnEenheid()
	{
		assertEquals(meting(37, gram()), meting(37, gram()));
	}

	@Test
	public void metingZijnOngelijkBijOngelijkeWaarde()
	{
		assertFalse(meting(37, gram()).equals(meting(51, gram())));
	}

	@Test
	public void metingZijnOngelijkBijOngelijkeEenheden()
	{
		assertFalse(meting(37, gram()).equals(meting(37, meter())));
	}
}
