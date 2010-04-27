/**
 * 
 */
package org.effrafax.comiccollection.domain.model;

import java.io.Serializable;

import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;
import org.effrafax.comiccollection.domain.model.interfaces.Indexable;
import org.effrafax.comiccollection.domain.model.interfaces.Nameable;

/**
 * This interface represents one comic album.
 * 
 * @author dvberkel
 */
public interface Album extends Nameable, Indexable, Identifiable, Serializable {

}
