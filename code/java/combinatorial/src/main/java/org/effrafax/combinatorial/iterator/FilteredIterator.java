/**
 * 
 */
package org.effrafax.combinatorial.iterator;

import java.util.Iterator;

import org.effrafax.combinatorial.iterator.filter.Filter;

/**
 * @author dvberkel
 * 
 */
public class FilteredIterator<E> implements Iterator<E>
{

	private final Iterator<E> iterator;

	private final Filter<E> filter;

	private E currentElement;

	public FilteredIterator(Iterator<E> iterator, Filter<E> filter)
	{
		this.iterator = iterator;
		this.filter = filter;
	}

	@Override
	public boolean hasNext()
	{
		while (iterator.hasNext())
		{
			currentElement = iterator.next();
			if (filter.pass(currentElement))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public E next()
	{
		return currentElement;
	}

	@Override
	public void remove()
	{
		iterator.remove();
	}

}
