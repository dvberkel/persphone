/**
 * 
 */
package org.effrafax.comiccollection.domain.factory;

import org.effrafax.comiccollection.domain.factory.implementation.SimpleEntityFactory;
import org.effrafax.comiccollection.domain.repository.Repository;
import org.effrafax.comiccollection.domain.repository.implementation.InMemoryRepository;

/**
 * @author dvberkel
 */
public enum FactoryProvider {

	/**
	 * The singleton {@link FactoryProvider}.
	 */
	PROVIDER;

	/**
	 * The singleton {@link EntityFactory}.
	 */
	private EntityFactory entityFactory;

	/**
	 * the singleton {@link Repository}
	 */
	private Repository repository;

	/**
	 * Returns an singleton implementation of the {@link EntityFactory}
	 * interface.
	 * 
	 * @return an implementation of {@link EntityFactory}.
	 */
	public EntityFactory getEntityFactory() {

		if (entityFactory == null) {
			entityFactory = new SimpleEntityFactory();
		}

		return entityFactory;
	}

	/**
	 * Returns an singleton implementation of the {@link Repository} interface.
	 * 
	 * @return an implementation of {@link Repository}
	 */
	public Repository getRepository() {

		if (repository == null) {
			repository = new InMemoryRepository();
		}

		return repository;
	}
}
