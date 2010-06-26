/**
 * 
 */
package org.effrafax.combinatorial.iterator.filter;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.effrafax.combinatorial.iterator.filter.impl.AllPass;
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
		Filter<Integer> filter = new AllPass<Integer>();
		assertTrue(filter.pass((new Random()).nextInt()));
	}
}
