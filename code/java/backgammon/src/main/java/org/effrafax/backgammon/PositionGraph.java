/**
 * 
 */
package org.effrafax.backgammon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.effrafax.backgammon.listener.ReadyObserver;
import org.effrafax.backgammon.proto.ProtoPositionIterator;

/**
 * @author dvberkel
 * 
 */
public class PositionGraph implements ReadyObserver<Position>
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
			positionRepository.retrieve(iterator.next()).add(this);
		}
	}

	private void connectPositions()
	{
		numberOfMoves = 0;
		for (Position position : positionRepository.positions())
		{
			Map<Dice, Set<Position>> options = new HashMap<Dice, Set<Position>>();
			Set<Position> reachablePositions = new HashSet<Position>();
			for (Dice die : Dice.values())
			{
				Set<Position> optionsPerDie = positionRepository.canonicalPositions(position.moves(die));
				reachablePositions.addAll(optionsPerDie);
				options.put(die, optionsPerDie);
			}
			for (Position reachableOption : reachablePositions)
			{
				reachableOption.add(position);
			}
			int numberOfOptions = reachablePositions.size();
			numberOfMoves += numberOfOptions;
			System.out.println(numberOfMoves());
			position.setNumberOfMoves(numberOfOptions);
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

	@Override
	public void readyEvent(Position observable)
	{
		calculateNumberOfMoves(observable);
	}

	private void calculateNumberOfMoves(Position position)
	{
		position.setNumberOfMoves(0);
	}
}
