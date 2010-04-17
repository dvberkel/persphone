/**
 * 
 */
package org.effrafax.comiccollection.domain.service;

import java.util.Collection;

import org.effrafax.comiccollection.domain.factory.RepositoryFactory;
import org.effrafax.comiccollection.domain.model.Omnibus;

/**
 * @author dvberkel
 */
public class RetrievalService {

	/**
	 * Returns all {@link Omnibus}ses.
	 * 
	 * @return all {@link Omnibus}ses.
	 */
	public static Collection<Omnibus> getAllOmnibusses() {

		return RepositoryFactory.getRepository().loadAllOmnibusses();
	}
}
