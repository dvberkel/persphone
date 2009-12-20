/**
 * 
 */
package org.effrafax.math.tsp.solver.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author dvberkel
 * 
 */
public class PermutationIterator<E> implements Iterator<List<E>>
{
	/** The original list of elements to be permutated. */
	private List<E> original = null;

	/** The current permutation. */
	private int[] current = null;

	/**
	 * Returns an int array of length {@code k}. The array is filled with the ints 0 through k-1.
	 * 
	 * @param k
	 *            The length of the returned array.
	 * @return An int array filled with 0, 1, 2, ..., {@code k - 1}
	 */
	public static int[] range(int k)
	{

		int[] range = new int[k];

		for (int index = 0; index < k; index++)
		{

			range[index] = index;
		}

		return range;
	}

	/**
	 * Creates a subset of the original collection. Only and all the elements with the corresponding {@code indices}
	 * will be in the subset.
	 * 
	 * @param indices
	 *            The {@code indices} to be selected.
	 * @return The subset of the original collection.
	 */
	public static <E> List<E> collect(List<E> collection, int[] indices)
	{
		List<E> subset = new ArrayList<E>();
		for (int index : indices)
		{
			subset.add(collection.get(index));
		}

		return subset;
	}

	public PermutationIterator(Collection<E> collection)
	{

		if (collection == null)
		{

			throw new IllegalArgumentException("collection should not be null");
		}

		this.original = new ArrayList<E>();
		original.addAll(collection);

		if (this.original.size() > 0)
		{
			this.current = range(this.original.size());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext()
	{

		return current != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#next()
	 */
	@Override
	public List<E> next()
	{

		int[] copy = Arrays.copyOf(current, current.length);

		/* Find the start index of the longest decreasing tail. */
		int index = current.length - 1;
		while (index > 0 && current[index - 1] > current[index])
		{
			index--;
		}

		if (index == 0)
		{
			/* current is: [n, n-1, ..., 2, 1]. So we are finished. */
			current = null;
		}
		else
		{
			/*
			 * current is: [h_1, h_2, ..., h_p, t_1, t_2, ..., t_q] where p + q = n, h_p < t_1 and t_1 > t_2 > ... > t_p
			 * 
			 * Find the index of the least element in the tail which is greater then h_p.
			 */
			int swapIndex = index - 1;
			while (index < current.length && current[index] > current[swapIndex])
			{

				index++;
			}
			index--;

			/* Swap the elements at swapIndex and index */
			int element = current[swapIndex];
			current[swapIndex] = current[index];
			current[index] = element;

			/* reverse tail */
			swapIndex++;
			int[] tail = Arrays.copyOfRange(current, swapIndex, current.length);
			for (index = 0; index < tail.length; index++)
			{

				current[swapIndex + index] = tail[(tail.length - 1) - index];
			}
		}

		return collect(original, copy);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove()
	{

		throw new UnsupportedOperationException();
	}

}
