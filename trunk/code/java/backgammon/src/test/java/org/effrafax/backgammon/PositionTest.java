/**
 * 
 */
package org.effrafax.backgammon;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.effrafax.backgammon.listener.ReadyObserver;
import org.effrafax.backgammon.proto.ProtoPosition;
import org.effrafax.util.Utils;
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

		Utils.assertEqualInts(1, moves.size());
		Utils.assertCollectionContains(moves, new Position(new ProtoPosition(0, 1, 0, 0)));
	}

	@Test
	public void possiblePipMovesWith2Pips()
	{
		Set<Position> positions = position.pipMoves(2);

		Utils.assertEqualInts(2, positions.size());
		Utils.assertCollectionContains(positions, new Position(new ProtoPosition(1, 0, 1, 0, 0)), new Position(
			new ProtoPosition(0, 0, 1, 0)));
	}

	@Test
	public void possiblePipMovesWith4Pips()
	{
		Set<Position> positions = position.pipMoves(4);

		Utils.assertEqualInts(1, positions.size());
		Utils.assertCollectionContains(positions, new Position(new ProtoPosition(0, 1, 0, 0)));
	}

	public void possibleDiceMovesWith32()
	{
		Set<Position> positions = position.moves(Dice.THREE_TWO);

		Utils.assertEqualInts(2, positions.size());
		Utils.assertCollectionContains(positions, new Position(new ProtoPosition(0, 1, 0, 0)), new Position(
			new ProtoPosition(1, 0, 0, 0)));
	}

	@Test
	public void pipMovesWithSmallBoard()
	{
		Set<Position> moves = position.pipMoves(6);

		Utils.assertEqualInts(1, moves.size());
		Utils.assertCollectionContains(moves, new Position(new ProtoPosition(0, 1, 0, 0)));
	}

	@Test
	public void expectedNumberOfPlies()
	{
		Position emptyPosition = new Position(new ProtoPosition(0));
		emptyPosition.add(position);
		emptyPosition.setNumberOfPlies(0);

		Utils.assertEqualInts(0, emptyPosition.numberOfPlies());
		Utils.assertEqualInts(1, position.pliesUpdatesObserved());
	}

	@Test
	public void numberOfMoves()
	{
		assertNull(position.numberOfMoves());
	}

	@Test
	public void getReady()
	{
		AnObserver anObserver = new AnObserver();

		position.setNumberOfMoves(1);
		position.add(anObserver);

		Position emptyPosition = new Position(new ProtoPosition(0));
		emptyPosition.add(position);
		emptyPosition.setNumberOfPlies(0);

		assertTrue(anObserver.isObserved());
	}
}

class AnObserver implements ReadyObserver<Position>
{

	private boolean observed = false;

	@Override
	public void readyEvent(Position observable)
	{
		observed = true;
	}

	public boolean isObserved()
	{
		return observed;
	}
}
