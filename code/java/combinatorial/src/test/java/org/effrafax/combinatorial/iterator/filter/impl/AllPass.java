/**
 * 
 */
package org.effrafax.combinatorial.iterator.filter.impl;

import org.effrafax.combinatorial.iterator.filter.Filter;

/**
 * @author dvberkel
 * 
 */
public class AllPass<E> implements Filter<E>
{

	@Override
	public boolean pass(E element)
	{
		return true;
	}

}
