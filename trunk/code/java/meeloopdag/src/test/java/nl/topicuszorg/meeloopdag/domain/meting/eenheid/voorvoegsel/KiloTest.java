package nl.topicuszorg.meeloopdag.domain.meting.eenheid.voorvoegsel;

import static nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid.gram;
import static nl.topicuszorg.meeloopdag.domain.meting.eenheid.voorvoegsel.Kilo.kilo;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class KiloTest
{
	@Test
	public void kiloIsEenVoorVoegsel()
	{
		assertNotNull(kilo(gram()));
	}
}
