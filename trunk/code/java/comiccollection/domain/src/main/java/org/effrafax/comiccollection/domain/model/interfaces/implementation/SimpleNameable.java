/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces.implementation;

import org.effrafax.comiccollection.domain.model.interfaces.Nameable;
import org.effrafax.comiccollection.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class SimpleNameable implements Nameable {

	/** */
	private static final long serialVersionUID = 37L;
	/**
	 * This field will hold the reference to association made by this
	 * {@link SimpleNameable}.
	 */
	private String name;

	/**
	 * The constructor for this {@link SimpleNameable}.
	 * 
	 * @param name
	 *            the name which will be associated with this
	 *            {@link SimpleNameable}.
	 */
	public SimpleNameable(String name) {

		setName(name);
	}

	/**
	 * @see org.effrafax.comiccollection.domain.model.interfaces.Nameable#getName()
	 */
	@Override
	public String getName() {

		return name;
	}

	/**
	 * The setter for the name.
	 * 
	 * @param name
	 *            the name which will be associated with this
	 *            {@link SimpleNameable}.
	 * @throws IllegalArgumentException
	 *             if {@code name} is null.
	 */
	private void setName(String name) {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull(name);
		this.name = name;
	}

}
