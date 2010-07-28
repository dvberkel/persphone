package org.effrafax.comiccollection.persistence.db4o;

import java.util.Collection;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.repository.Repository;
import org.effrafax.comiccollection.persistence.db4o.service.Db4oService;

/**
 * @author dvberkel
 * 
 */
public class Db4oRepository implements Repository
{
	private Db4oService service = new Db4oService();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadAlbum(java.lang.Long)
	 */
	@Override
	public Album loadAlbum(Long albumId)
	{
		return service.loadIdentifiable(albumId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadAllOmnibusses()
	 */
	@Override
	public Collection<Omnibus> loadAllOmnibusses()
	{
		return service.loadAllIdentifiable();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadComic(java.lang.Long)
	 */
	@Override
	public Comic loadComic(Long comicId)
	{
		return service.loadIdentifiable(comicId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadOmnibus(java.lang.Long)
	 */
	@Override
	public Omnibus loadOmnibus(Long omnibusId)
	{
		return service.loadIdentifiable(omnibusId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.effrafax.comiccollection.domain.repository.Repository#saveAlbum(org.effrafax.comiccollection.domain.model
	 * .Album)
	 */
	@Override
	public Long saveAlbum(Album album)
	{
		service.saveAlbum(album);
		return album.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.effrafax.comiccollection.domain.repository.Repository#saveComic(org.effrafax.comiccollection.domain.model
	 * .Comic)
	 */
	@Override
	public Long saveComic(Comic comic)
	{
		service.saveComic(comic);
		return comic.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.effrafax.comiccollection.domain.repository.Repository#saveOmnibus(org.effrafax.comiccollection.domain.model
	 * .Omnibus)
	 */
	@Override
	public Long saveOmnibus(Omnibus omnibus)
	{
		service.saveOmnibus(omnibus);
		return omnibus.getId();
	}

}
