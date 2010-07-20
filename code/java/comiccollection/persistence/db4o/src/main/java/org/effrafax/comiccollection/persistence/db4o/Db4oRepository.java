package org.effrafax.comiccollection.persistence.db4o;

import java.util.Collection;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.repository.Repository;

/**
 * @author dvberkel
 * 
 */
public class Db4oRepository implements Repository
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadAlbum(java.lang.Long)
	 */
	@Override
	public Album loadAlbum(Long albumId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadAllOmnibusses()
	 */
	@Override
	public Collection<Omnibus> loadAllOmnibusses()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadComic(java.lang.Long)
	 */
	@Override
	public Comic loadComic(Long comicId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadOmnibus(java.lang.Long)
	 */
	@Override
	public Omnibus loadOmnibus(Long omnibusId)
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
