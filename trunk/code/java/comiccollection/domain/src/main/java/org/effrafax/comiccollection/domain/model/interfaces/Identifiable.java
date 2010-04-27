/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces;

import java.io.Serializable;

/**
 * This interface determence the identity of objects.
 * 
 * @author dvberkel
 */
public interface Identifiable extends Serializable {

	/**
	 * Returns the id.
	 * 
	 * @return id
	 */
	public Long getId();

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the id to set.
	 */
	public void setId(Long id);
}
