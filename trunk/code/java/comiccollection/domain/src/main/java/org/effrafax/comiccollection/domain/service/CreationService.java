/**
 * 
 */
package org.effrafax.comiccollection.domain.service;

import org.effrafax.comiccollection.domain.factory.Factory;
import org.effrafax.comiccollection.domain.factory.RepositoryFactory;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.repository.Repository;

/**
 * @author dvberkel
 */
public class CreationService {

	/**
	 * Creates an omnibus and registers it with the repository.
	 * 
	 * @return an Omnibus.
	 */
	public static Omnibus createOmnibus() {

		Omnibus omnibus = Factory.createOmnibus();
		Repository repository = RepositoryFactory.getRepository();
		repository.saveOmnibus(omnibus);
		return omnibus;
	}

	/**
	 * Adds a {@link Comic} with {@code name} to the {@link Omnibus} with
	 * {@code omnibusId}.
	 * 
	 * @param omnibusId
	 *            the id of the {@link Omnibus}.
	 * @param name
	 *            the name of the {@link Comic} to add.
	 */
	public static void addComic(Long omnibusId, String name) {

		Repository repository = RepositoryFactory.getRepository();
		Omnibus omnibus = repository.loadOmnibus(omnibusId);
		omnibus.addComic(Factory.createComic(name));
		repository.saveOmnibus(omnibus);
	}
}
