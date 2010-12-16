package nl.topicuszorg.meeloopdag.domain.meting.bmi;

import nl.topicuszorg.meeloopdag.domain.meting.Meting;
import nl.topicuszorg.meeloopdag.domain.meting.bmi.builder.BMICalculatorBuilder;
import nl.topicuszorg.meeloopdag.domain.meting.bmi.builder.CurriedBMICalculatorBuilder;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Gram;
import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Meter;

public final class BMICalculator
{

	private final Meting<Gram> gewichtMeting;

	private final Meting<Meter> lengteMeting;

	public static BMICalculatorBuilder bereken()
	{
		return new BMICalculatorBuilder();
	}

	public BMICalculator(CurriedBMICalculatorBuilder curriedBMICalculatorBuilder)
	{
		this.gewichtMeting = curriedBMICalculatorBuilder.getGewichtMeting();
		this.lengteMeting = curriedBMICalculatorBuilder.getLengteMeting();
	}

	public Meting<?> bmi()
	{
		return gewichtMeting.gedeeldDoor(lengteMeting.maal(lengteMeting));
	}
}