/**
 * 
 */
package org.effrafax.comiccollection.persistence.jdbc.dto;

import org.effrafax.comiccollection.domain.model.Omnibus;

/**
 * @author dvberkel
 */
public class OmnibusDTO {

	/**
	 * Field for the corresponding {@link Omnibus} property.
	 */
	private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {

		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {

		this.id = id;
	}
}
