/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces.comparators;

import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;

/**
 * @author dvberkel
 * 
 */
public class IdentifiableComparator<T extends Identifiable> extends AbstractComparator<T>
{
	@Override
	protected int nonNullCompare(T anObject, T otherObject)
	{
		return anObject.getId().compareTo(otherObject.getId());
	}

}
