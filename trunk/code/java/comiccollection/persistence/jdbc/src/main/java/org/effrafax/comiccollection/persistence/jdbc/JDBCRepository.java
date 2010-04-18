/**
 * 
 */
package org.effrafax.comiccollection.persistence.jdbc;

import java.util.Collection;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.provider.Provider;
import org.effrafax.comiccollection.domain.repository.Repository;
import org.effrafax.comiccollection.persistence.jdbc.dto.AlbumDTO;
import org.effrafax.comiccollection.persistence.jdbc.dto.ComicDTO;
import org.effrafax.comiccollection.persistence.jdbc.service.JDBCService;
import org.effrafax.comiccollection.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class JDBCRepository implements Repository {

	private final JDBCService jdbcService = new JDBCService();

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadAlbum(java.lang.Long)
	 */
	@Override
	public Album loadAlbum(Long id) {

		AlbumDTO albumDTO = jdbcService.loadAlbumDTO(id);
		Album album = null;
		if (!ArgumentChecker.isNull(albumDTO)) {
			album = Provider.PROVIDER.getEntityFactory().createAlbum(albumDTO.getIndex(), albumDTO.getName());
			album.setId(albumDTO.getId());
		}
		return album;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadAllOmnibusses()
	 */
	@Override
	public Collection<Omnibus> loadAllOmnibusses() {

		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadComic(java.lang.Long)
	 */
	@Override
	public Comic loadComic(Long id) {

		ComicDTO comicDTO = jdbcService.loadComicDTO(id);
		Comic comic = null;
		if (!ArgumentChecker.isNull(comicDTO)) {
			comic = Provider.PROVIDER.getEntityFactory().createComic(comicDTO.getName());
			comic.setId(comicDTO.getId());
			for (Long albumId : jdbcService.getContainedAlbumIDs(id)) {
				Album album = loadAlbum(albumId);
				comic.addAlbum(album);
			}
		}
		return comic;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadOmnibus(java.lang.Long)
	 */
	@Override
	public Omnibus loadOmnibus(Long id) {

		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#saveAlbum(org.effrafax.comiccollection.domain.model.Album)
	 */
	@Override
	public Long saveAlbum(Album album) {

		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#saveComic(org.effrafax.comiccollection.domain.model.Comic)
	 */
	@Override
	public Long saveComic(Comic comic) {

		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#saveOmnibus(org.effrafax.comiccollection.domain.model.Omnibus)
	 */
	@Override
	public Long saveOmnibus(Omnibus omnibus) {

		// TODO Auto-generated method stub
		return null;
	}

}
