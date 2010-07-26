/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces.comparators;

import org.effrafax.comiccollection.domain.model.interfaces.Indexable;

/**
 * @author dvberkel
 * 
 */
public class IndexableComparator<T extends Indexable> extends AbstractComparator<T>
{

	@Override
	protected int nonNullCompare(T anObject, T otherObject)
	{
		return anObject.getIndex().compareTo(otherObject.getIndex());
	}

}
