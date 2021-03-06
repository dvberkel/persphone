/**
 * 
 */
package org.effrafax.comiccollection.domain.service;

import java.util.Collection;

import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.provider.Provider;

/**
 * @author dvberkel
 */
public abstract class RetrievalService {

	/**
	 * Returns all {@link Omnibus}ses.
	 * 
	 * @return all {@link Omnibus}ses.
	 */
	public static Collection<Omnibus> getAllOmnibusses() {

		return Provider.PROVIDER.getRepository().loadAllOmnibusses();
	}

	/**
	 * Returns a {@link Omnibus} with {@code id}.
	 * 
	 * @param id
	 *            the id of the {@link Omnibus}.
	 * @return the {@link Omnibus} with {@code id} if it exists.
	 */
	public static Omnibus getOmnibus(Long id) {

		return Provider.PROVIDER.getRepository().loadOmnibus(id);
	}

	/**
	 * Returns a {@link Comic} with {@code id}.
	 * 
	 * @param id
	 *            the id of the {@link Comic}.
	 * @return the {@link Comic} with {@code id} if it exists.
	 */
	public static Comic getComic(Long id) {

		return Provider.PROVIDER.getRepository().loadComic(id);
	}
}
