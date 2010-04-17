/**
 * 
 */
package org.effrafax.comiccollection.domain.factory;

import org.effrafax.comiccollection.domain.factory.implementation.SimpleEntityFactory;

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
	 * Returns an implementation of the {@link EntityFactory} interface.
	 * 
	 * @return an implementation of {@link EntityFactory}.
	 */
	public EntityFactory getEntityFactory() {

		if (entityFactory == null) {
			entityFactory = new SimpleEntityFactory();
		}

		return entityFactory;
	}
}
