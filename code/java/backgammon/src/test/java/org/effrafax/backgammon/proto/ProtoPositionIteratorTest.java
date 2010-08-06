package org.effrafax.backgammon.proto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.effrafax.util.Utils;
import org.junit.Before;
import org.junit.Test;

public class ProtoPositionIteratorTest
{
	private ProtoPositionIterator protoPositionIterator;

	@Before
	public void createIterator()
	{
		protoPositionIterator = new ProtoPositionIterator(2, 1);
	}

	@Test
	public void testHasNext()
	{
		assertTrue(protoPositionIterator.hasNext());
	}

	@Test
	public void testNext()
	{
		assertEquals(new ProtoPosition(0), protoPositionIterator.next());
	}

	@Test
	public void testSeriesOfNext()
	{
		assertTrue(protoPositionIterator.hasNext());
		assertEquals(new ProtoPosition(0), protoPositionIterator.next());
		assertTrue(protoPositionIterator.hasNext());
		assertEquals(new ProtoPosition(1, 0), protoPositionIterator.next());
		assertTrue(protoPositionIterator.hasNext());
		assertEquals(new ProtoPosition(0, 1), protoPositionIterator.next());
		assertFalse(protoPositionIterator.hasNext());
	}

	@Test
	public void testCreationSpeed()
	{
		int count = 0;
		long startMoment = new Date().getTime();
		ProtoPositionIterator iterator = new ProtoPositionIterator(6, 15);
		while (iterator.hasNext())
		{
			count++;
			iterator.next();
		}
		long finishMoment = new Date().getTime();

		System.out.format("Iterator speed test: %d ms\n", finishMoment - startMoment);
		Utils.assertEqualInts(54264, count);
	}
}
