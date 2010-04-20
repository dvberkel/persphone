/**
 * 
 */
package org.effrafax.comiccollection.persistence.jdbc;

import java.util.Collection;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.builder.ComicBuilder;
import org.effrafax.comiccollection.domain.builder.OmnibusBuilder;
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.provider.Provider;
import org.effrafax.comiccollection.domain.repository.Repository;
import org.effrafax.comiccollection.persistence.jdbc.service.JDBCService;
import org.effrafax.comiccollection.util.ArgumentChecker;

/**
 * @author dvberkel
 */
public class JDBCRepository implements Repository {

	/**
	 * The {@link JDBCService} which will provides the connection with the
	 * database.
	 */
	private final JDBCService jdbcService = new JDBCService();

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadAlbum(java.lang.Long)
	 */
	@Override
	public Album loadAlbum(Long id) {

		AlbumBuilder albumBuilder = jdbcService.loadAlbumBuilder(id);
		Album album = null;
		if (!ArgumentChecker.isNull(albumBuilder)) {
			album = Provider.PROVIDER.getEntityFactory().createAlbum(albumBuilder);
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

		ComicBuilder comicBuilder = jdbcService.loadComicBuilder(id);
		Comic comic = null;
		if (!ArgumentChecker.isNull(comicBuilder)) {
			comic = Provider.PROVIDER.getEntityFactory().createComic(null);
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

		OmnibusBuilder omnibusBuilder = jdbcService.loadOmnibusBuilder(id);
		Omnibus omnibus = null;
		if (!ArgumentChecker.isNull(omnibus)) {
			omnibus = Provider.PROVIDER.getEntityFactory().createOmnibus(omnibusBuilder);
			for (Long comicID : jdbcService.getContainedComicIDs(id)) {
				Comic comic = loadComic(comicID);
				omnibus.addComic(comic);
			}
		}
		return omnibus;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#saveAlbum(org.effrafax.comiccollection.domain.model.Album)
	 */
	@Override
	public Long saveAlbum(Album album) {

		return jdbcService.saveOrUpdateAlbum(album);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#saveComic(org.effrafax.comiccollection.domain.model.Comic)
	 */
	@Override
	public Long saveComic(Comic comic) {

		return jdbcService.saveOrUpdateComic(comic);
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
