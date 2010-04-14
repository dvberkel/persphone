/**
 * 
 */
package org.effrafax.comiccollection.domain.model;

import java.util.Collection;

import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;

/**
 * This interface represants a omnibus of {@link Comic}s.
 * 
 * @author dvberkel
 */
public interface Omnibus extends Identifiable {

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
