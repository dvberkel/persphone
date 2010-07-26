/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces.comparators;

import org.effrafax.comiccollection.domain.model.interfaces.Nameable;

/**
 * @author dvberkel
 * 
 */
public class NameableComparator<T extends Nameable> extends AbstractComparator<T>
{
	@Override
	protected int nonNullCompare(T anObject, T otherObject)
	{
		return anObject.getName().compareTo(otherObject.getName());
	}

}
