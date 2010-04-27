/**
 * 
 */
package org.effrafax.comiccollection.domain.model.interfaces;

import java.io.Serializable;

/**
 * This class represenant the possibility to index a certain object.
 * 
 * @author dvberkel
 */
public interface Indexable extends Serializable {

	/**
	 * Returns the index associated with this object.
	 * 
	 * @return the index of this object.
	 */
	public Integer getIndex();
}
