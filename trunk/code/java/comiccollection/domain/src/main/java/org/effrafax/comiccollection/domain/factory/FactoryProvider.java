/**
 * 
 */
package org.effrafax.comiccollection.domain.factory;

import java.util.ServiceLoader;

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
			entityFactory = createEntityFactory();
		}

		return entityFactory;
	}

	/**
	 * Create an {@link EntityFactory}.
	 * 
	 * @return an {@link EntityFactory}
	 */
	private EntityFactory createEntityFactory() {

		// return getInstance(EntityFactory.class);
		return new SimpleEntityFactory();
	}

	/**
	 * Returns an singleton implementation of the {@link Repository} interface.
	 * 
	 * @return an implementation of {@link Repository}
	 */
	public Repository getRepository() {

		if (repository == null) {
			repository = createRepository();
		}

		return repository;
	}

	/**
	 * Create an {@link Repository}.
	 * 
	 * @return an {@link Repository}
	 */
	private Repository createRepository() {

		return new InMemoryRepository();
	}

	/**
	 * Returns a specific provider of a service.
	 * 
	 * @param <S>
	 *            The generic class of the provider.
	 * @param service
	 *            The service.
	 * @return A provider for {@code service}.
	 */
	private <S> S getInstance(Class<S> service) {

		ServiceLoader<S> serviceLoader = ServiceLoader.load(service);

		for (S provider : serviceLoader) {

			/* We are expecting only one provider */
			return provider;
		}

		throw new IllegalStateException("No provider registered for service " + service.toString());
	}
}
