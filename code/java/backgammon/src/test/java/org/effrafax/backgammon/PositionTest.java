/**
 * 
 */
package org.effrafax.backgammon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.effrafax.backgammon.proto.ProtoPosition;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dvberkel
 * 
 */
public class PositionTest
{
	private Position position;

	@Before
	public void createPosition()
	{
		position = new Position(new ProtoPosition(0, 1, 0, 1, 0));
	}

	@Test
	public void possiblePipMovesWith3Pips()
	{
		Set<Position> moves = position.pipMoves(3);

		assertEquals(Integer.valueOf(1), Integer.valueOf(moves.size()));
		assertTrue(moves.contains(new Position(new ProtoPosition(0, 1, 0, 0))));
	}

	@Test
	public void possiblePipMovesWith2Pips()
	{
		Set<Position> positions = position.pipMoves(2);

		assertEquals(Integer.valueOf(2), Integer.valueOf(positions.size()));
		assertTrue(positions.contains(new Position(new ProtoPosition(1, 0, 1, 0, 0))));
		assertTrue(positions.contains(new Position(new ProtoPosition(0, 0, 1, 0))));
	}

	@Test
	public void possiblePipMovesWith4Pips()
	{
		Set<Position> positions = position.pipMoves(4);

		assertEquals(Integer.valueOf(1), Integer.valueOf(positions.size()));
		assertTrue(positions.contains(new Position(new ProtoPosition(0, 1, 0, 0))));
	}
}
