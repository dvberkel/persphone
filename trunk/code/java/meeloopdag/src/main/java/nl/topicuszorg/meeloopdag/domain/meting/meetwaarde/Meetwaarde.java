package nl.topicuszorg.meeloopdag.domain.meting.meetwaarde;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Meetwaarde implements Serializable
{
	private static final long serialVersionUID = 37L;

	public static Meetwaarde meetwaarde(int waarde)
	{
		return new Meetwaarde(BigDecimal.valueOf(waarde));
	}

	public static Meetwaarde meetwaarde(double waarde)
	{
		return new Meetwaarde(BigDecimal.valueOf(waarde));
	}

	private final BigDecimal waarde;

	private Meetwaarde(BigDecimal waarde)
	{
		this.waarde = waarde;
	}

	public Meetwaarde maal(Meetwaarde meetwaarde)
	{
		return new Meetwaarde(waarde.multiply(meetwaarde.waarde));
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
		return getFormatter().format(waarde);
	}

	private DecimalFormat getFormatter()
	{
		DecimalFormat formatter = null;
		if (isGeheel())
		{
			formatter = new DecimalFormat("#0");
		}
		else
		{
			formatter = new DecimalFormat("#0.00");
		}
		return formatter;
	}

	private boolean isGeheel()
	{
		return waarde.stripTrailingZeros().scale() <= 0;
	}
}