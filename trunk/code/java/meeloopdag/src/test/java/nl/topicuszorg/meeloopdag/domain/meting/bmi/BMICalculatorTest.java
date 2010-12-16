package nl.topicuszorg.meeloopdag.domain.meting.bmi;

import static nl.topicuszorg.meeloopdag.domain.meting.Meting.meting;
import static nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid.gedeeld;
import static nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid.gram;
import static nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid.meter;
import static nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid.samengesteld;
import static org.junit.Assert.assertEquals;
import nl.topicuszorg.meeloopdag.domain.meting.Meting;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Gram;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Meter;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BMICalculatorTest
{
	private BMICalculator bmiCalculator;

	private Meting<Gram> gewichtMeting;

	private Meting<Meter> lengteMeting;

	@Before
	public void maakGewichtMeting()
	{
		gewichtMeting = meting(80000, gram());
	}

	@Before
	public void maakLengteMeting()
	{
		lengteMeting = meting(1.85, meter());
	}

	@Ignore
	@Test
	public void berekenBMI()
	{
		assertEquals(meting(23.37473, gedeeld(gram(), samengesteld(meter(), meter()))), BMICalculator.bereken().met(
			gewichtMeting).en(lengteMeting).bmi());
	}
}
