package nl.topicuszorg.meeloopdag.domain.meting.meetwaarde;

import java.io.Serializable;

public class Meetwaarde implements Serializable
{
	private static final long serialVersionUID = 37L;

	public static Meetwaarde meetwaarde(int waarde)
	{
		return new Meetwaarde(waarde);
	}

	private final Integer waarde;

	private Meetwaarde(Integer waarde)
	{
		this.waarde = waarde;
	}

	public Meetwaarde maal(Meetwaarde meetwaarde)
	{
		return new Meetwaarde(waarde * meetwaarde.waarde);
	}

	@Override
	public int hashCode()
	{
		return waarde.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Meetwaarde))
			return false;
		Meetwaarde other = (Meetwaarde) obj;
		return this.waarde.equals(other.waarde);
	}

	@Override
	public String toString()
	{
		return waarde.toString();
	}

}
