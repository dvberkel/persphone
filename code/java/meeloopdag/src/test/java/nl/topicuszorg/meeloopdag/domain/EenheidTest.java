package nl.topicuszorg.meeloopdag.domain;

import static nl.topicuszorg.meeloopdag.domain.Eenheid.gram;
import static nl.topicuszorg.meeloopdag.domain.Eenheid.meter;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class EenheidTest
{
	@Test
	public void gramIsEenEenheid()
	{
		assertNotNull(gram());
	}

	@Test
	public void deEneGramIsPreciesDeAndereGram()
	{
		assertSame(gram(), gram());
	}

	@Test
	public void meterIsEenEenheid()
	{
		assertNotNull(meter());
	}

	@Test
	public void deEneMeterIsPreciesDeAndereMeter()
	{
		assertSame(meter(), meter());
	}
}
