package nl.topicuszorg.meeloopdag.domain.eenheid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Eenheid implements Comparable<Eenheid>
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

	public static SamengesteldeEenheid samengesteld(Eenheid eenEenheid, Eenheid andereEenheid)
	{
		return new SamengesteldeEenheid(eenEenheid, andereEenheid);
	}

	public Eenheid maal(Eenheid eenheid)
	{
		return samengesteld(this, eenheid);
	}

	@Override
	public int compareTo(Eenheid o)
	{
		return this.getClass().getName().compareTo(o.getClass().getName());
	}
}

final class Gram extends Eenheid
{

}

final class Meter extends Eenheid
{

}

final class SamengesteldeEenheid extends Eenheid
{

	final private List<Eenheid> eenheden = new ArrayList<Eenheid>();

	public SamengesteldeEenheid(Eenheid... eenheden)
	{
		this.eenheden.addAll(Arrays.asList(eenheden));
		Collections.sort(this.eenheden);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eenheden == null) ? 0 : eenheden.hashCode());
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
		SamengesteldeEenheid other = (SamengesteldeEenheid) obj;
		if (eenheden == null)
		{
			if (other.eenheden != null)
				return false;
		}
		else if (!eenheden.equals(other.eenheden))
			return false;
		return true;
	}

}