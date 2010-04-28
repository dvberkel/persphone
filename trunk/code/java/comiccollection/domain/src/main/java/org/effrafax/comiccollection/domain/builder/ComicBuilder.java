/**
 * 
 */
package org.effrafax.comiccollection.domain.builder;

import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;
import org.effrafax.comiccollection.domain.model.interfaces.Nameable;
import org.effrafax.comiccollection.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class ComicBuilder implements Identifiable, Nameable {

	/** */
	private static final long serialVersionUID = 37L;

	/**
	 * Reference to the id.
	 */
	private Long id;
	/**
	 * Reference to the name.
	 */
	private String name;

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.model.interfaces.Nameable#getName()
	 */
	@Override
	public String getName() {

		return name;
	}

	/**
	 * Setter for name.
	 * 
	 * @param name
	 *            the name to set.
	 */
	public void setName(String name) {

		this.name = name;
	}

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
	 * @see org.effrafax.comiccollection.domain.model.interfaces.Identifiable#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * Determines if this builder is complete.
	 * 
	 * @return {@code true} if {@code name} is present, {@code false} otherwise.
	 */
	public boolean isComplete() {

		return !ArgumentChecker.isNull(getName()) && !getName().isEmpty();
	}

}
