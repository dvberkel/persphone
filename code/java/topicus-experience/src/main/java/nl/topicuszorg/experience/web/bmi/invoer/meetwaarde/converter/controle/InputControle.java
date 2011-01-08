package nl.topicuszorg.experience.web.bmi.invoer.meetwaarde.converter.controle;

import java.io.Serializable;

public interface InputControle extends Serializable
{
	boolean correcteInput(String input);
}
