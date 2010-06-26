/**
 * 
 */
package org.effrafax.combinatorial.iterator.filter.impl;

import java.util.Arrays;

import org.effrafax.combinatorial.iterator.filter.Filter;

/**
 * @author dvberkel
 * 
 */
public class GraphicSequenceFilter implements Filter<int[]>
{

	@Override
	public boolean pass(int[] element)
	{
		return isGraphic(element);
	}

	private boolean isGraphic(int... sequence)
	{

		while (!isADefaultGraphic(sequence))
		{
			if (isReducible(sequence))
			{
				sequence = reduce(sequence);
			}
			else
			{
				return false;
			}
		}
		return true;
	}

	private boolean isADefaultGraphic(int[] sequence)
	{

		boolean isGraphic = true;
		for (int degree : sequence)
		{
			isGraphic &= degree == 0;
		}
		return isGraphic;
	}

	private boolean isReducible(int... sequence)
	{

		return isMonotonicDecreasing(sequence) && havelHakimiCriteria(sequence);
	}

	private boolean isMonotonicDecreasing(int... sequence)
	{

		int index = 0;
		while (index < sequence.length - 1 && sequence[index] >= sequence[index + 1])
			index++;
		return sequence.length == 1 || !(index < sequence.length - 1);
	}

	private boolean havelHakimiCriteria(int... sequence)
	{

		boolean isCriteria = sequence[0] < sequence.length;
		if (isCriteria)
		{
			for (int index = 1; index <= sequence[0]; index++)
			{
				isCriteria &= sequence[index] > 0;
			}
		}
		return isCriteria;
	}

	private int[] reduce(int... sequence)
	{

		int[] result = Arrays.copyOfRange(sequence, 1, sequence.length);
		for (int index = 0; index < sequence[0]; index++)
		{
			result[index] -= 1;
		}
		Arrays.sort(result);
		return reverse(result);
	}

	private int[] reverse(int... sequence)
	{

		int[] result = new int[sequence.length];
		for (int index = 0; index < sequence.length; index++)
		{
			result[index] = sequence[sequence.length - 1 - index];
		}
		return result;
	}
}
