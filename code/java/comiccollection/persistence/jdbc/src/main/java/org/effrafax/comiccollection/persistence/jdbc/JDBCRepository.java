/**
 * 
 */
package org.effrafax.comiccollection.persistence.jdbc;

import java.util.Collection;
import java.util.HashSet;

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
	private JDBCService jdbcService;

	/**
	 * constructor of this Repository.
	 */
	public JDBCRepository() {

		setJdbcService(new JDBCService());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadAlbum(java.lang.Long)
	 */
	@Override
	public Album loadAlbum(Long id) {

		AlbumBuilder albumBuilder = getJdbcService().loadAlbumBuilder(id);
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

		Collection<Omnibus> omnibusses = new HashSet<Omnibus>();
		for (OmnibusBuilder omnibusBuilder : getJdbcService().loadAllOmnibusBuilders()) {
			Omnibus omnibus = Provider.PROVIDER.getEntityFactory().createOmnibus(omnibusBuilder);
			omnibusses.add(omnibus);
		}
		return omnibusses;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#loadComic(java.lang.Long)
	 */
	@Override
	public Comic loadComic(Long id) {

		ComicBuilder comicBuilder = getJdbcService().loadComicBuilder(id);
		Comic comic = null;
		if (!ArgumentChecker.isNull(comicBuilder)) {
			comic = Provider.PROVIDER.getEntityFactory().createComic(comicBuilder);
			for (Long albumId : getJdbcService().getContainedAlbumIDs(id)) {
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

		OmnibusBuilder omnibusBuilder = getJdbcService().loadOmnibusBuilder(id);
		Omnibus omnibus = null;
		if (!ArgumentChecker.isNull(omnibusBuilder)) {
			omnibus = Provider.PROVIDER.getEntityFactory().createOmnibus(omnibusBuilder);
			for (Long comicID : getJdbcService().getContainedComicIDs(id)) {
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

		return getJdbcService().saveOrUpdateAlbum(album);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#saveComic(org.effrafax.comiccollection.domain.model.Comic)
	 */
	@Override
	public Long saveComic(Comic comic) {

		return getJdbcService().saveOrUpdateComic(comic);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.effrafax.comiccollection.domain.repository.Repository#saveOmnibus(org.effrafax.comiccollection.domain.model.Omnibus)
	 */
	@Override
	public Long saveOmnibus(Omnibus omnibus) {

		return getJdbcService().saveOrUpdateOmnibus(omnibus);
	}

	/**
	 * @param jdbcService
	 *            the jdbcService to set
	 */
	public void setJdbcService(JDBCService jdbcService) {

		if (ArgumentChecker.isNull(jdbcService)) {
			throw new IllegalArgumentException("jdbcService should not be null.");
		}
		this.jdbcService = jdbcService;
	}

	/**
	 * @return the jdbcService
	 */
	private JDBCService getJdbcService() {

		return jdbcService;
	}

}
