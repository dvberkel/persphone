package nl.topicuszorg.experience.web.bmi.invoer.meetwaarde.converter.controle;

public class GebrokenGetalControle implements InputControle
{
	private static final long serialVersionUID = 37L;

	@Override
	public boolean correcteInput(String input)
	{
		return input.matches("(0|-?[1-9]\\d*)(\\.\\d*)?||\\.\\d+");
	}
}