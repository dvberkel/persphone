package nl.topicuszorg.meeloopdag.domain.eenheid;

import static nl.topicuszorg.meeloopdag.domain.eenheid.Eenheid.gram;
import static nl.topicuszorg.meeloopdag.domain.eenheid.Eenheid.meter;
import static nl.topicuszorg.meeloopdag.domain.eenheid.Eenheid.samengesteld;
import static org.junit.Assert.assertEquals;
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

	@Test
	public void erZijnSamengesteldeEenheden()
	{
		assertNotNull(samengesteld(gram(), meter()));
	}

	@Test
	public void samenGesteldeEenhedenZijnCommutatief()
	{
		assertEquals(samengesteld(gram(), meter()), samengesteld(meter(), gram()));
	}

	@Test
	public void eenhedenKunnenWordenVermenigvuldigd()
	{
		assertEquals(samengesteld(gram(), meter()), gram().maal(meter()));
	}
}
