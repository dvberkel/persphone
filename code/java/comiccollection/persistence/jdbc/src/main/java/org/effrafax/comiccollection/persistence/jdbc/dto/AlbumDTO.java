/**
 * 
 */
package org.effrafax.comiccollection.persistence.jdbc.dto;

import org.effrafax.comiccollection.domain.model.Album;

/**
 * @author dvberkel
 */
public class AlbumDTO {

	/**
	 * Field for the corresponding {@link Album} property.
	 */
	private Long id;
	/**
	 * Field for the corresponding {@link Album} property.
	 */
	private Integer index;
	/**
	 * Field for the corresponding {@link Album} property.
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
	 * @return the index
	 */
	public Integer getIndex() {

		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(Integer index) {

		this.index = index;
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
