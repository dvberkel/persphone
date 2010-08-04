package org.effrafax.backgammon.proto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class ProtoTest
{
	private ProtoPosition protoPosition;

	@Before
	public void createAProtoPosition()
	{
		protoPosition = new ProtoPosition(0, 1, 0, 1, 0);
	}

	@Test
	public void countNumberOfPoints()
	{
		assertEqualInts(4, protoPosition.numberOfPoints());
	}

	@Test
	public void countNumberOfStones()
	{
		assertEqualInts(2, protoPosition.numberOfStones());
	}

	private void assertEqualInts(int expected, int actual)
	{
		assertEquals(Integer.valueOf(expected), Integer.valueOf(actual));
	}

	@Test
	public void partitionedPosition()
	{
		assertArrayEquals(new int[] { 0, 1, 1, 0 }, protoPosition.partition());
	}

	@Test
	public void nextProtoPosition()
	{
		assertEquals(new ProtoPosition(0, 1, 0, 0, 1), protoPosition.next());
		assertEquals(new ProtoPosition(0, 0, 1, 1, 0), protoPosition.next().next());
		assertEquals(new ProtoPosition(0, 0, 1, 0, 1), protoPosition.next().next().next());
		assertEquals(new ProtoPosition(0, 0, 0, 1, 1), protoPosition.next().next().next().next());
		assertNull(protoPosition.next().next().next().next().next());
	}
}
