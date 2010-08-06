/**
 * 
 */
package org.effrafax.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

/**
 * @author dvberkel
 * 
 */
public class Utils
{
	public static void assertEqualInts(int expected, int actual)
	{
		assertEquals(Integer.valueOf(expected), Integer.valueOf(actual));
	}

	public static <T> void assertCollectionContains(Collection<T> collection, T... elements)
	{
		for (T element : elements)
		{
			assertTrue(collection.contains(element));
		}
	}
}
