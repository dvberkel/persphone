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
	public static Iterator<int[]> ofLength(int length)
	{
		return new FilteredIterator<int[]>(new MonotonicDecreasingIterator(length, length - 1),
			new GraphicSequenceFilter());
	}
}
