/**
 * 
 */
package org.effrafax.comiccollection.domain.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;
import org.effrafax.comiccollection.domain.model.interfaces.Nameable;

/**
 * This class represants a comic series.
 * 
 * @author dvberkel
 */
public interface Comic extends Nameable, Identifiable, Serializable
{

	/**
	 * Adds an @{link Album} to this comic.
	 * 
	 * @param album
	 *            the {@link Album} added to this {@link Comic}.
	 */
	public void addAlbum(Album album);

	/**
	 * Returns the {@link Album}s collected in this {@code Comic}.
	 * 
	 * @return the {@link Album}s.
	 */
	public List<Album> getAlbums();

	/**
	 * Returns a list of indices missing from this {@link Comic}.
	 * 
	 * @return the missing indices.
	 */
	public Set<Integer> getWishes();
}
