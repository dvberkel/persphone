package nl.topicuszorg.meeloopdag.domain.meting.eenheid.voorvoegsel;

import nl.topicuszorg.meeloopdag.domain.meting.eenheid.Eenheid;

public class Kilo<T extends Eenheid> extends Eenheid
{
	private T eenheid;

	public static <E extends Eenheid> Kilo<E> kilo(E eenheid)
	{
		return new Kilo<E>(eenheid);
	}

	private Kilo(T eenheid)
	{
		this.eenheid = eenheid;
	}
}
