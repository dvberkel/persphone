/**
 * 
 */
package org.effrafax.combinatorial.iterator.filter.impl;

import org.effrafax.combinatorial.iterator.filter.Filter;

/**
 * @author dvberkel
 * 
 */
public class NonPass<E> implements Filter<Integer>
{

	@Override
	public boolean pass(Integer element)
	{
		return false;
	}

}
