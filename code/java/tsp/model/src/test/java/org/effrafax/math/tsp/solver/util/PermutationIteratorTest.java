/**
 * 
 */
package org.effrafax.math.tsp.solver.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class PermutationIteratorTest
{

	@Test(expected = IllegalArgumentException.class)
	public void testInitialisationFailure()
	{
		new PermutationIterator<Integer>(null);
	}

	@Test
	public void testEmptyCollection()
	{

		Collection<Integer> testCollection = Collections.emptyList();

		Iterator<List<Integer>> iterator = new PermutationIterator<Integer>(testCollection);

		assertFalse(iterator.hasNext());
	}

	@Test
	public void testSingletonCollection()
	{

		Collection<Integer> testCollection = Collections.singleton(0);

		Iterator<List<Integer>> iterator = new PermutationIterator<Integer>(testCollection);

		assertTrue(iterator.hasNext());

		List<Integer> list = iterator.next();
		assertEquals(1, list.size());
		assertEquals(0, (int) list.get(0));

		assertFalse(iterator.hasNext());
	}

	@Test
	public void testSimpleCollection()
	{

		Collection<Integer> testCollection = Arrays.asList(0, 1);

		Iterator<List<Integer>> iterator = new PermutationIterator<Integer>(testCollection);

		assertTrue(iterator.hasNext());

		List<Integer> list = iterator.next();
		assertEquals(2, list.size());
		assertEquals(0, (int) list.get(0));
		assertEquals(1, (int) list.get(1));

		assertTrue(iterator.hasNext());

		list = iterator.next();
		assertEquals(2, list.size());
		assertEquals(1, (int) list.get(0));
		assertEquals(0, (int) list.get(1));

		assertFalse(iterator.hasNext());
	}

	@Test
	public void testComplexCollection()
	{

		Collection<Integer> testCollection = Arrays.asList(0, 1, 2);
		int[][] expected = new int[][] { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 0, 1 }, { 2, 1, 0 } };

		Iterator<List<Integer>> iterator = new PermutationIterator<Integer>(testCollection);
		for (int index = 0; index < expected.length; index++)
		{

			assertTrue(iterator.hasNext());

			List<Integer> list = iterator.next();
			for (int listIndex = 0; listIndex < list.size(); listIndex++)
			{

				assertEquals(expected[index][listIndex], (int) list.get(listIndex));
			}
		}
	}

}
