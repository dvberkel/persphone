/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces.comparators;

import java.util.Comparator;

/**
 * @author dvberkel
 * 
 */
public abstract class AbstractComparator<T> implements Comparator<T>
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(T anObject, T otherObject)
	{
		if (anObject == null && otherObject == null)
		{
			return 0;
		}
		else if (anObject == null && otherObject != null)
		{
			return -1;
		}
		else if (anObject != null && otherObject == null)
		{
			return 1;
		}
		else
		{
			return nonNullCompare(anObject, otherObject);
		}
	}

	protected abstract int nonNullCompare(T anObject, T otherObject);

}
