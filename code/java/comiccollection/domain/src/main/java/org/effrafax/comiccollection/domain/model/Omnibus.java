/**
 * 
 */
package org.effrafax.comiccollection.domain.model;

import java.util.Collection;

/**
 * This interface represants a omnibus of {@link Comic}s.
 * 
 * @author dvberkel
 */
public interface Omnibus {

	/**
	 * Adds a {@link Comic} to this {@link Omnibus}.
	 * 
	 * @param comic
	 *            the {@link Comic} which gets added.
	 */
	public void addComic(Comic comic);

	/**
	 * Returns all {@link Comic}s associated with this {@link Omnibus}.
	 * 
	 * @return all the {@link Comic}s associated with this {@link Omnibus}.
	 */
	public Collection<Comic> getComics();
}
