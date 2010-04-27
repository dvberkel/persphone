/**
 * 
 */
package org.effrafax.comiccollection.domain.builder;

import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;

/**
 * @author dvberkel
 */
public class OmnibusBuilder implements Identifiable {

	/** */
	private static final long serialVersionUID = 37L;

	/**
	 * References the id.
	 */
	private Long id;

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.interfaces.Identifiable#getId()
	 */
	@Override
	public Long getId() {

		return this.id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.interfaces.Identifiable#setId
	 *      (java.lang.Long)
	 */
	@Override
	public void setId(Long id) {

		this.id = id;
	}

}
