/**
 * 
 */
package org.effrafax.comiccollection.domain.service;

import org.effrafax.comiccollection.domain.factory.Factory;
import org.effrafax.comiccollection.domain.factory.RepositoryFactory;
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

	public static void addComic(Long omnibusId, String name) {

		Repository repository = RepositoryFactory.getRepository();
		Omnibus omnibus = repository.loadOmnibus(omnibusId);
		omnibus.addComic(Factory.createComic(name));
		repository.saveOmnibus(omnibus);

	}
}
