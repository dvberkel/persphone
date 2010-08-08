/**
 * 
 */
package org.effrafax.backgammon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.effrafax.backgammon.listener.PliesObservable;
import org.effrafax.backgammon.listener.PliesObserver;
import org.effrafax.backgammon.listener.ReadyObservable;
import org.effrafax.backgammon.listener.ReadyObserver;
import org.effrafax.backgammon.proto.ProtoPosition;

/**
 * @author dvberkel
 * 
 */
public class Position implements PliesObservable, PliesObserver, ReadyObservable
{
	private final int[] partition;

	private List<PliesObserver> pliesObservers = new ArrayList<PliesObserver>();

	private List<ReadyObserver> readyObservers = new ArrayList<ReadyObserver>();

	private int pliesUpdatesObserved = 0;

	private Integer numberOfPlies;

	private Integer numberOfMoves;

	public Position(ProtoPosition protoPosition)
	{
		this(protoPosition.partition());
	}

	private Position(int[] partition)
	{
		this.partition = Arrays.copyOf(partition, partition.length);
	}

	public Set<Position> pipMoves(int pip)
	{
		Set<Position> moves = new HashSet<Position>();
		int count = 0;
		int index = pip - 1;
		while (index < partition.length)
		{
			if (partition[index] > 0)
			{
				count++;
				moves.add(move(index, pip));
			}
			index++;
		}
		if (count == 0)
		{
			index = pip - 2;
			while (index >= 0 && (index >= partition.length || partition[index] == 0))
			{
				index--;
			}
			if (index >= 0)
			{
				moves.add(move(index, pip));
			}
		}
		return moves;
	}

	private Position move(int index, int pip)
	{
		int[] newPartition = Arrays.copyOf(partition, partition.length);
		newPartition[index]--;
		if (index - pip >= 0)
		{
			newPartition[index - pip]++;
		}
		Position position = new Position(newPartition);
		return position;
	}

	public Set<Position> moves(Dice dice)
	{
		Set<Position> result = new HashSet<Position>();
		for (int[] pipSequence : dice.pipSequences())
		{
			result.addAll(moves(pipSequence));
		}

		return result;
	}

	private Set<Position> moves(int[] pipSequence)
	{
		Set<Position> result = new HashSet<Position>();
		result.add(this);
		for (int pip : pipSequence)
		{
			Set<Position> partialResult = new HashSet<Position>();
			for (Position position : result)
			{
				partialResult.addAll(position.pipMoves(pip));
			}
			result = partialResult;
		}
		return result;
	}

	@Override
	public String toString()
	{
		return Arrays.toString(partition);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(partition);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (!Arrays.equals(partition, other.partition))
			return false;
		return true;
	}

	public Integer numberOfPlies()
	{
		return numberOfPlies;
	}

	public void setNumberOfPlies(Integer numberOfPlies)
	{
		this.numberOfPlies = numberOfPlies;
		for (PliesObserver observer : pliesObservers)
		{
			observer.pliesUpdatedEvent();
		}
	}

	@Override
	public void add(PliesObserver observer)
	{
		pliesObservers.add(observer);

	}

	public Integer numberOfMoves()
	{
		return numberOfMoves;
	}

	public void setNumberOfMoves(Integer numberOfMoves)
	{
		this.numberOfMoves = numberOfMoves;
	}

	@Override
	public void pliesUpdatedEvent()
	{
		pliesUpdatesObserved += 1;
		if (numberOfMoves != null && numberOfMoves == pliesUpdatesObserved)
		{
			ready();
		}
	}

	private void ready()
	{
		for (ReadyObserver observer : readyObservers)
		{
			observer.readyEvent(this);
		}
	}

	public int pliesUpdatesObserved()
	{
		return pliesUpdatesObserved;
	}

	@Override
	public void add(ReadyObserver observer)
	{
		readyObservers.add(observer);
	}

}
