package nl.topicuszorg.meeloopdag.domain.meting.bmi.builder;

import nl.topicuszorg.meeloopdag.domain.meting.Meting;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Gram;

public final class BMICalculatorBuilder
{

	public CurriedBMICalculatorBuilder met(Meting<Gram> gewichtMeting)
	{
		return new CurriedBMICalculatorBuilder(gewichtMeting);
	}

}
