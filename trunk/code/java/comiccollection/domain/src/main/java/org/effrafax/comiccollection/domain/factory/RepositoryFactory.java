/**
 * 
 */
package org.effrafax.comiccollection.domain.factory;

import org.effrafax.comiccollection.domain.repository.Repository;
import org.effrafax.comiccollection.domain.repository.implementation.InMemoryRepository;

/**
 * @author dvberkel
 */
public class RepositoryFactory {

	/**
	 * The singleton instance for this {@link RepositoryFactory}.
	 */
	private static Repository repository;

	/**
	 * Returns the sole instance of this {@link RepositoryFactory}.
	 * 
	 * @return an {@link Repository}.
	 */
	public static Repository getRepository() {

		if (repository == null) {
			repository = createRepository();
		}
		return repository;
	}

	/**
	 * Creates an {@link Repository}.
	 * 
	 * @return an {@link Repository}.
	 */
	private static Repository createRepository() {

		return new InMemoryRepository();
	}
}
