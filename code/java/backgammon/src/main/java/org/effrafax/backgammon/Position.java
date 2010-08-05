/**
 * 
 */
package org.effrafax.backgammon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.effrafax.backgammon.proto.ProtoPosition;

/**
 * @author dvberkel
 * 
 */
public class Position
{
	private final int[] partition;

	public Position(ProtoPosition protoPosition)
	{
		this(protoPosition.partition());
	}

	private Position(int[] partition)
	{
		this.partition = partition;
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
			while (index >= 0 && partition[index] == 0)
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
}
