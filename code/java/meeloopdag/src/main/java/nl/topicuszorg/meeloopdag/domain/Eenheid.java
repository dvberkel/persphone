package nl.topicuszorg.meeloopdag.domain;

import java.util.HashMap;
import java.util.Map;

public class Eenheid
{
	private static Map<Class<? extends Eenheid>, Object> eenheden = createMap();

	private static <K, V> Map<K, V> createMap()
	{
		return new HashMap<K, V>();
	}

	@SuppressWarnings("unchecked")
	private static <T extends Eenheid> T geefEenheidVanType(Class<T> eenheidClass)
	{

		if (!eenheden.containsKey(eenheidClass))
		{
			try
			{
				eenheden.put(eenheidClass, eenheidClass.newInstance());
			}
			catch (InstantiationException e)
			{
				throw new IllegalStateException(e);
			}
			catch (IllegalAccessException e)
			{
				throw new IllegalStateException(e);
			}
		}
		return (T) eenheden.get(eenheidClass);
	}

	public static Gram gram()
	{
		return geefEenheidVanType(Gram.class);
	}

	public static Meter meter()
	{
		return geefEenheidVanType(Meter.class);
	}
}

final class Gram extends Eenheid
{

}

final class Meter extends Eenheid
{

}