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
public class IndiscriminatePredicate<T extends Identifiable> extends Predicate<T>
{

	/** */
	private static final long serialVersionUID = 37L;

	@Override
	public boolean match(T identifiable)
	{
		return true;
	}

}
