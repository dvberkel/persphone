/**
 * 
 */
package org.effrafax.comiccollection.domain.model;

import java.io.Serializable;
import java.util.List;

import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;

/**
 * This interface represants a omnibus of {@link Comic}s.
 * 
 * @author dvberkel
 */
public interface Omnibus extends Identifiable, Serializable {

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
	public List<Comic> getComics();
}
