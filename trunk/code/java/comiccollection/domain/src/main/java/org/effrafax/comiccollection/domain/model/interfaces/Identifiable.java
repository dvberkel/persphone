/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces;

/**
 * This interface determence the identity of objects.
 * 
 * @author dvberkel
 */
public interface Identifiable {

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
