/**
 * 
 */
package org.effrafax.comiccollection.persistence.jdbc.dto;

import org.effrafax.comiccollection.domain.model.Comic;

/**
 * @author dvberkel
 */
public class ComicDTO {

	/**
	 * Field for the corresponding {@link Comic} property.
	 */
	private Long id;
	/**
	 * Field for the corresponding {@link Comic} property.
	 */
	private String name;

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

	/**
	 * @return the name
	 */
	public String getName() {

		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {

		this.name = name;
	}
}
