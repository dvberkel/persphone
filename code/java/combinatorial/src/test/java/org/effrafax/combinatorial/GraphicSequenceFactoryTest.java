package org.effrafax.combinatorial;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

public class GraphicSequenceFactoryTest
{
	@Test
	public void testGraphicSequenceOfLengthThree()
	{

		Iterator<int[]> iterator = GraphicSequenceIteratorFactory.createGraphicSequenceIterator(3);

		assertTrue(iterator.hasNext());
		assertArrayEquals(new int[] { 0, 0, 0 }, iterator.next());
		assertTrue(iterator.hasNext());
		assertArrayEquals(new int[] { 1, 1, 0 }, iterator.next());
		assertTrue(iterator.hasNext());
		assertArrayEquals(new int[] { 2, 1, 1 }, iterator.next());
		assertTrue(iterator.hasNext());
		assertArrayEquals(new int[] { 2, 2, 2 }, iterator.next());
		assertFalse(iterator.hasNext());
	}
}
