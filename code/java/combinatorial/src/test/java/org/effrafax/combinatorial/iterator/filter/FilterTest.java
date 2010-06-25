/**
 * 
 */
package org.effrafax.combinatorial.iterator.filter;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.effrafax.combinatorial.iterator.filter.Filter;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class FilterTest
{
	@Test
	public void testAllPassFilter()
	{
		Filter<Integer> filter = new Filter<Integer>()
		{

			@Override
			public boolean pass(Integer element)
			{
				return true;
			}
		};
		assertTrue(filter.pass((new Random()).nextInt()));
	}
}
