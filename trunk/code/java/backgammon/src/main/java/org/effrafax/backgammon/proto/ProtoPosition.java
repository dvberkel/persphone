package org.effrafax.backgammon.proto;

import java.util.Arrays;

public class ProtoPosition
{
	private int[] position;

	public ProtoPosition(int... position)
	{
		this.position = position;
	}

	public int numberOfPoints()
	{
		return 1 + countZeroes();
	}

	private int countZeroes()
	{
		return count(0);
	}

	private int count(int value)
	{
		int number = 0;
		for (int index = 0; index < position.length; index++)
		{
			if (value == position[index])
			{
				number += 1;
			}
		}
		return number;

	}

	public int numberOfStones()
	{
		return count(1);
	}

	public int[] partition()
	{
		int[] partition = new int[numberOfPoints()];
		Arrays.fill(partition, 0);

		int pointer = 0;
		for (int index = 0; index < position.length; index++)
		{
			if (position[index] == 0)
			{
				pointer++;
			}
			else
			{
				partition[pointer]++;
			}
		}

		return partition;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(position);
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
		ProtoPosition other = (ProtoPosition) obj;
		if (!Arrays.equals(position, other.position))
			return false;
		return true;
	}

	public ProtoPosition next()
	{
		int[] nextPosition = Arrays.copyOf(position, position.length);
		int index = nextPosition.length - 1;
		while (index >= 0 && nextPosition[index] == 0)
		{
			index--;
		}
		if (index < 0)
		{
			return null;
		}
		if (index != nextPosition.length - 1)
		{
			nextPosition[index] = 0;
			nextPosition[index + 1] = 1;
		}
		else
		{
			int count = 0;
			while (nextPosition[index] == 1)
			{
				count++;
				index--;
			}
			while (index >= 0 && nextPosition[index] == 0)
			{
				index--;
			}
			if (index < 0)
			{
				return null;
			}
			count++;
			nextPosition[index] = 0;
			for (int i = index + 1; i < nextPosition.length; i++)
			{
				if (count > 0)
				{
					nextPosition[i] = 1;
					count--;
				}
				else
				{
					nextPosition[i] = 0;
				}
			}
		}
		return new ProtoPosition(nextPosition);
	}

	@Override
	public String toString()
	{
		return Arrays.toString(position);
	}
}
