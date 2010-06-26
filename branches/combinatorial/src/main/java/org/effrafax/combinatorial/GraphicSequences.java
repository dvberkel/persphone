/**
 * 
 */
package org.effrafax.combinatorial;

import java.util.Iterator;

import org.effrafax.combinatorial.iterator.FilteredIterator;
import org.effrafax.combinatorial.iterator.MonotonicDecreasingIterator;
import org.effrafax.combinatorial.iterator.filter.impl.GraphicSequenceFilter;

/**
 * @author dvberkel
 * 
 */
public abstract class GraphicSequences
{
	private static final GraphicSequenceFilter filter = new GraphicSequenceFilter();

	public static Iterable<int[]> ofLength(final int length)
	{
		return new Iterable<int[]>()
		{

			@Override
			public Iterator<int[]> iterator()
			{
				return new FilteredIterator<int[]>(new MonotonicDecreasingIterator(length, length - 1), filter);
			}
		};
	}
}
