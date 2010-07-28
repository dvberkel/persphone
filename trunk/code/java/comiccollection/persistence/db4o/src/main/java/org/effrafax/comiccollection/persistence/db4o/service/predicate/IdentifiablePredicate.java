/**
 * 
 */
package org.effrafax.comiccollection.persistence.db4o.service.predicate;

import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;

import com.db4o.query.Predicate;

/**
 * @author dvberkel
 * 
 */
public class IdentifiablePredicate<T extends Identifiable> extends Predicate<T>
{
	/** */
	private static final long serialVersionUID = 37L;

	private final Long id;

	public IdentifiablePredicate(Long id)
	{
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.db4o.query.Predicate#match(java.lang.Object)
	 */
	@Override
	public boolean match(T identifiable)
	{
		return identifiable.getId().equals(id);
	}

}
