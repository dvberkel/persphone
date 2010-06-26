package org.effrafax.combinatorial.iterator.filter.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GraphicSequenceFilterTest
{

	private GraphicSequenceFilter filter;

	@Before
	public void createGraphicSequenceFilter()
	{
		filter = new GraphicSequenceFilter();
	}

	@Test
	public void testZeroSequence()
	{

		assertTrue(filter.pass(new int[] { 0 }));
	}

	@Test
	public void testOneSequence()
	{

		assertFalse(filter.pass(new int[] { 1 }));
	}

	@Test
	public void testZeroesSequence()
	{

		assertTrue(filter.pass(new int[] { 0, 0 }));
		assertTrue(filter.pass(new int[] { 0, 0, 0 }));
		assertTrue(filter.pass(new int[] { 0, 0, 0, 0 }));
	}

	@Test
	public void testOnesSequence()
	{

		assertTrue(filter.pass(new int[] { 1, 1 }));
	}

	@Test
	public void testMultipleDifferentSequences()
	{

		assertTrue(filter.pass(new int[] { 1, 1 }));
		assertTrue(filter.pass(new int[] { 2, 1, 1 }));
		assertFalse(filter.pass(new int[] { 3, 1, 1 }));
		assertTrue(filter.pass(new int[] { 3, 1, 1, 1 }));
		assertFalse(filter.pass(new int[] { 3, 1, 1, 0 }));
		assertFalse(filter.pass(new int[] { 3, 1, 1, 1, 1 }));
		assertTrue(filter.pass(new int[] { 3, 1, 1, 1, 1, 1 }));
	}

}
