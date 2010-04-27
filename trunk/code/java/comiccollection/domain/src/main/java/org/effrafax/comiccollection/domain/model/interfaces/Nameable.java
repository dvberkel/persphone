/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces;

import java.io.Serializable;

/**
 * This class represants the property that an object is Nameable.
 * 
 * @author dvberkel
 */
public interface Nameable extends Serializable {

	/**
	 *This method returns the name associated with this object.
	 * 
	 * @return the the name of this object.
	 */
	public String getName();
}
