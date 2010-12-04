package nl.topicuszorg.meeloopdag.domain;

import static nl.topicuszorg.meeloopdag.domain.Meetwaarde.meetwaarde;

public class Meting<E extends Eenheid>
{
	public static <T extends Eenheid> Meting<T> meting(int waarde, T eenheid)
	{
		return new Meting<T>(waarde, eenheid);
	}

	private final Meetwaarde meetwaarde;

	private final E eenheid;

	private Meting(int i, E eenheid)
	{
		this.meetwaarde = meetwaarde(i);
		this.eenheid = eenheid;
	}

	@Override
	public int hashCode()
	{
		final int prime = 37;
		int result = 1;
		result = prime * result + ((eenheid == null) ? 0 : eenheid.hashCode());
		result = prime * result + ((meetwaarde == null) ? 0 : meetwaarde.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meting other = (Meting) obj;
		if (eenheid == null)
		{
			if (other.eenheid != null)
				return false;
		}
		else if (!eenheid.equals(other.eenheid))
			return false;
		if (meetwaarde == null)
		{
			if (other.meetwaarde != null)
				return false;
		}
		else if (!meetwaarde.equals(other.meetwaarde))
			return false;
		return true;
	}
}
