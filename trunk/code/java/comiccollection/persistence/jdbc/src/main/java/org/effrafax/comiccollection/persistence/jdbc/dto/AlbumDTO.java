/**
 * 
 */
package org.effrafax.comiccollection.persistence.jdbc.dto;

/**
 * @author dvberkel
 */
public class AlbumDTO {

	private Long id;
	private Integer index;
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
