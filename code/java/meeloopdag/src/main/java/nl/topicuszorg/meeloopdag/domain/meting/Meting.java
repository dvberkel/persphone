package nl.topicuszorg.meeloopdag.domain.meting;

import static nl.topicuszorg.meeloopdag.domain.meting.meetwaarde.Meetwaarde.meetwaarde;

import java.io.Serializable;

import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid;
import nl.topicuszorg.meeloopdag.domain.meting.meetwaarde.Meetwaarde;

public class Meting<E extends Eenheid> implements Serializable
{
	private static final long serialVersionUID = 37L;

	public static <T extends Eenheid> Meting<T> meting(int waarde, T eenheid)
	{
		return meting(meetwaarde(waarde), eenheid);
	}

	public static <T extends Eenheid> Meting<T> meting(double waarde, T eenheid)
	{
		return meting(meetwaarde(waarde), eenheid);
	}

	public static <T extends Eenheid> Meting<T> meting(Meetwaarde meetwaarde, T eenheid)
	{
		return new Meting<T>(meetwaarde, eenheid);
	}

	private final Meetwaarde meetwaarde;

	private final E eenheid;

	private Meting(Meetwaarde meetwaarde, E eenheid)
	{
		this.meetwaarde = meetwaarde;
		this.eenheid = eenheid;
	}

	public Meting<?> maal(Meting<?> meting)
	{
		return meting(this.meetwaarde.maal(meting.meetwaarde), this.eenheid.maal(meting.eenheid));

	}

	public Meetwaarde getMeetwaarde()
	{
		return meetwaarde;
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

	@SuppressWarnings("unchecked")
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

	@Override
	public String toString()
	{
		return String.format("%s%s", meetwaarde.toString(), eenheid.toString());
	}
}
