/**
 * 
 */
package org.effrafax.comiccollection.domain.model;

import java.io.Serializable;

import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;
import org.effrafax.comiccollection.domain.model.interfaces.Indexable;
import org.effrafax.comiccollection.domain.model.interfaces.Nameable;
import org.effrafax.comiccollection.domain.model.visitor.AlbumVisitor;

/**
 * This interface represents one comic album.
 * 
 * @author dvberkel
 */
public interface Album extends Nameable, Indexable, Identifiable, Serializable {

	/**
	 * Accepts a {@code albumVisitor} to visit this {@link Album}.
	 * 
	 * @param albumVisitor
	 *            the {@link AlbumVisitor} visiting.
	 */
	public void accept(AlbumVisitor albumVisitor);
}
