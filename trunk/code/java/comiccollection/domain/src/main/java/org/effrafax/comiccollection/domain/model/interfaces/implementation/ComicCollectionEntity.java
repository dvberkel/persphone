/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces.implementation;

import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;

/**
 * This class is a common class for all the entities in this model
 * 
 * @author dvberkel
 */
public class ComicCollectionEntity extends ComicCollectionObject implements Identifiable {

	/** */
	private static final long serialVersionUID = 37L;

	/**
	 * The id of this {@link ComicCollectionEntity}.
	 */
	private Long id;

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.interfaces.Identifiable#getId()
	 */
	@Override
	public Long getId() {

		return id;
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
