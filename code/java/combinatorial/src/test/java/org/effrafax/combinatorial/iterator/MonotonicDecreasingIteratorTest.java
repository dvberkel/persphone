package org.effrafax.combinatorial.iterator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MonotonicDecreasingIteratorTest {

	@Test
	public void testIteratorOfLengthOneHeightTwo() {

		MonotonicDecreasingIterator iterator = new MonotonicDecreasingIterator(1, 2);

		assertTrue(iterator.hasNext());
		assertArrayEquals(new int[] {0}, iterator.next());
		assertTrue(iterator.hasNext());
		assertArrayEquals(new int[] {1}, iterator.next());
		assertTrue(iterator.hasNext());
		assertArrayEquals(new int[] {2}, iterator.next());
		assertFalse(iterator.hasNext());
	}

	@Test
	public void testIteratorOfLengthTwoHeightOne() {

		MonotonicDecreasingIterator iterator = new MonotonicDecreasingIterator(2, 1);

		assertTrue(iterator.hasNext());
		assertArrayEquals(new int[] {0, 0}, iterator.next());
		assertTrue(iterator.hasNext());
		assertArrayEquals(new int[] {1, 0}, iterator.next());
		assertTrue(iterator.hasNext());
		assertArrayEquals(new int[] {1, 1}, iterator.next());
		assertFalse(iterator.hasNext());
	}
}
