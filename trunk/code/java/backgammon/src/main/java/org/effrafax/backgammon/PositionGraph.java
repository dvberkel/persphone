/**
 * 
 */
package org.effrafax.backgammon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.effrafax.backgammon.proto.ProtoPositionIterator;

/**
 * @author dvberkel
 * 
 */
public class PositionGraph
{
	private PositionRepository positionRepository = new PositionRepository();

	private Map<Position, Map<Dice, Set<Position>>> reachable = new HashMap<Position, Map<Dice, Set<Position>>>();

	Integer numberOfMoves = -1;

	public PositionGraph(int numberOfPoints, int maxNumberOfStones)
	{
		fillRepository(numberOfPoints, maxNumberOfStones);
		connectPositions();
	}

	private void fillRepository(int numberOfPoints, int maxNumberOfStones)
	{
		ProtoPositionIterator iterator = new ProtoPositionIterator(numberOfPoints, maxNumberOfStones);
		while (iterator.hasNext())
		{
			positionRepository.retrieve(iterator.next());
		}
	}

	private void connectPositions()
	{
		numberOfMoves = 0;
		for (Position position : positionRepository.positions())
		{
			Map<Dice, Set<Position>> options = new HashMap<Dice, Set<Position>>();
			for (Dice die : Dice.values())
			{
				Set<Position> optionsPerDie = positionRepository.canonicalPositions(position.moves(die));
				numberOfMoves += optionsPerDie.size();
				options.put(die, optionsPerDie);
			}
			reachable.put(position, options);
		}
	}

	public int numberOfPositions()
	{
		return positionRepository.numberOfPositions();
	}

	public int numberOfMoves()
	{
		return numberOfMoves;
	}
}
