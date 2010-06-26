package org.effrafax.combinatorial.iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;

import org.effrafax.combinatorial.iterator.filter.impl.AllPass;
import org.effrafax.combinatorial.iterator.filter.impl.NonPass;
import org.junit.Before;
import org.junit.Test;

public class FilteredIteratorTest
{
	private Iterator<Integer> iterator;

	@Before
	public void createIterator()
	{
		iterator = Arrays.asList(new Integer[] { 1, 2, 3 }).iterator();
	}

	@Test
	public void testAllPassFilteredIterator()
	{
		Iterator<Integer> filteredIterator = new FilteredIterator<Integer>(iterator, new AllPass<Integer>());

		assertTrue(filteredIterator.hasNext());
		assertEquals(Integer.valueOf(1), filteredIterator.next());
		assertTrue(filteredIterator.hasNext());
		assertEquals(Integer.valueOf(2), filteredIterator.next());
		assertTrue(filteredIterator.hasNext());
		assertEquals(Integer.valueOf(3), filteredIterator.next());
		assertFalse(filteredIterator.hasNext());
	}

	@Test
	public void testNonPassFilteredIterator()
	{
		Iterator<Integer> filteredIterator = new FilteredIterator<Integer>(iterator, new NonPass<Integer>());

		assertFalse(filteredIterator.hasNext());
	}

}
