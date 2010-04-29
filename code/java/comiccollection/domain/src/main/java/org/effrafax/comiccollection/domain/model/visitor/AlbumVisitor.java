/**
 * 
 */
package org.effrafax.comiccollection.domain.model.visitor;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;

/**
 * this interface provides a means to visit all the {@link Album}s of a
 * {@link Comic}.
 * 
 * @author dvberkel
 */
public interface AlbumVisitor {

	/**
	 * Visits {@code album}.
	 * 
	 * @param album
	 *            the {@code Album} visited.
	 */
	public void visit(Album album);

}
