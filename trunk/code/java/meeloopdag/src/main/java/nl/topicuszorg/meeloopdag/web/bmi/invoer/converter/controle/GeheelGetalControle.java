package nl.topicuszorg.meeloopdag.web.bmi.invoer.converter.controle;

public class GeheelGetalControle implements InputControle
{

	@Override
	public boolean correcteInput(String input)
	{
		return input.matches("[1-9]\\d*");
	}

}
