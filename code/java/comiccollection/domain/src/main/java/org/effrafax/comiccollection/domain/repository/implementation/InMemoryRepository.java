/**
 * 
 */
package org.effrafax.comiccollection.domain.repository.implementation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;
import org.effrafax.comiccollection.domain.repository.Repository;
import org.effrafax.comiccollection.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class InMemoryRepository implements Repository {

	/**
	 * The next usable id for saving objects.
	 */
	private static Long nextId = 0L;

	/**
	 * Map from classes to a map of id to objects. Used to hold the references
	 * to the saved objects.
	 */
	private final Map<Class, Map<Long, Object>> classRepositoryMap = new HashMap<Class, Map<Long, Object>>();

	/**
	 * Loads an object from this {@link InMemoryRepository}.
	 * 
	 * @param <T>
	 *            the generic type of {@code object}.
	 * @param aClass
	 *            the class of {@code object}.
	 * @param id
	 *            the id of {@code Object}.
	 * @return the object of {@code aClass} with {@code id}.
	 */
	private <T extends Identifiable> T genericLoad(Class<T> aClass, Long id) {

		Map<Long, Object> objectMap = getClassRepositoryMap(aClass);

		T object = null;
		if (!ArgumentChecker.isNull(id) && objectMap.containsKey(id)) {
			object = aClass.cast(objectMap.get(id));
		}
		return object;
	}

	/**
	 * Returns the {@code classRepositoryMap} specific to {@code aClass}.
	 * 
	 * @param <T>
	 *            a generic type.
	 * @param aClass
	 *            the specifying class.
	 * @return an classSpecificRepository.
	 */
	private <T extends Identifiable> Map<Long, Object> getClassRepositoryMap(Class<T> aClass) {

		ArgumentChecker.throwExceptionIfAnyArgumentIsNull(aClass);
		if (!classRepositoryMap.containsKey(aClass)) {
			classRepositoryMap.put(aClass, new HashMap<Long, Object>());
		}
		Map<Long, Object> map = classRepositoryMap.get(aClass);
		return map;
	}

	/**
	 * Saves an Identifiable object in this {@link InMemoryRepository}.
	 * 
	 * @param <T>
	 *            the generic type of {@code object}
	 * @param aClass
	 *            the interface of {@code object}
	 * @param object
	 *            the object to be saved.
	 * @return the assigned id of {@code object}.
	 */
	private <T extends Identifiable> Long genericSave(Class<T> aClass, T object) {

		Map<Long, Object> objectMap = getClassRepositoryMap(aClass);
		if (ArgumentChecker.isNull(object.getId())) {
			object.setId(nextId());
		}
		objectMap.put(object.getId(), object);
		return object.getId();
	}

	/**
	 * Returns a list of all the objects of {@code aClass}.
	 * 
	 * @param <T>
	 *            the generic type of objects.
	 * @param aClass
	 *            the interface of objects.
	 * @return all objects of {@code aClass}.
	 */
	@SuppressWarnings("unchecked")
	private <T extends Identifiable> Collection<T> genericLoadAll(Class<T> aClass) {

		Map<Long, Object> objectMap = getClassRepositoryMap(aClass);
		return (Collection<T>) Collections.unmodifiableCollection(objectMap.values());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadAlbum(java
	 *      .lang.Long)
	 */
	@Override
	public Album loadAlbum(Long id) {

		return genericLoad(Album.class, id);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadComic(java
	 *      .lang.Long)
	 */
	@Override
	public Comic loadComic(Long id) {

		return genericLoad(Comic.class, id);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadOmnibus
	 *      (java.lang.Long)
	 */
	@Override
	public Omnibus loadOmnibus(Long id) {

		return genericLoad(Omnibus.class, id);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadAllOmnibusses()
	 */
	@Override
	public Collection<Omnibus> loadAllOmnibusses() {

		return genericLoadAll(Omnibus.class);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#saveAlbum(org
	 *      .effrafax.comiccollection.domain.model.Album)
	 */
	@Override
	public Long saveAlbum(Album album) {

		return genericSave(Album.class, album);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#saveComic(org
	 *      .effrafax.comiccollection.domain.model.Comic)
	 */
	@Override
	public Long saveComic(Comic comic) {

		return genericSave(Comic.class, comic);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#saveOmnibus
	 *      (org.effrafax.comiccollection.domain.model.Omnibus)
	 */
	@Override
	public Long saveOmnibus(Omnibus omnibus) {

		return genericSave(Omnibus.class, omnibus);
	}

	/**
	 * Returns the next id used in this {@link InMemoryRepository}.
	 * 
	 * @return next useable id.
	 */
	private static synchronized Long nextId() {

		return nextId++;
	}

}
