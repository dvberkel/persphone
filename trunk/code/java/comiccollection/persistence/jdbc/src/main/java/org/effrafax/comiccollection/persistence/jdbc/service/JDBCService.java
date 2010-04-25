/**
 * 
 */
package org.effrafax.comiccollection.persistence.jdbc.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

import org.effrafax.comiccollection.domain.builder.AlbumBuilder;
import org.effrafax.comiccollection.domain.builder.ComicBuilder;
import org.effrafax.comiccollection.domain.builder.OmnibusBuilder;
import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.model.interfaces.Identifiable;
import org.effrafax.comiccollection.util.ArgumentChecker;

/**
 * @author dvberkel
 */
/**
 * @author dvberkel
 */
public class JDBCService {

	/**
	 * The singleton connection with the database.
	 */
	private Connection connection = null;
	/**
	 * The field which will hold the nextId;
	 */
	private Long nextId;

	private Properties properties;

	/**
	 * The constructor for this {@link JDBCService}
	 */
	public JDBCService() {

		loadProperties();
		loadJDBCDriver();
	}

	/**
	 * Loads the properties.
	 */
	private void loadProperties() {

		Properties properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (FileNotFoundException exception) {
			throw new IllegalStateException(exception);
		} catch (IOException exception) {
			throw new IllegalStateException(exception);
		}
		setProperties(properties);
	}

	/**
	 * Loads the JDBC driver.
	 */
	private void loadJDBCDriver() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException exception) {
			throw new IllegalStateException(exception);
		}
	}

	/**
	 * Loads an {@link AlbumBuilder} from the databas.
	 * 
	 * @param id
	 *            the id of the corresponding {@link Album}.
	 * @return an {@link AlbumBuilder}.
	 */
	public AlbumBuilder loadAlbumBuilder(Long id) {

		AlbumBuilder albumBuilder = new AlbumBuilder();
		try {
			ResultSet resultSet = executeQuery(albumQuery(id));
			while (resultSet.next()) {
				albumBuilder.setId(new Long(resultSet.getInt("ID")));
				albumBuilder.setIndex(new Integer(resultSet.getInt("ALBUMINDEX")));
				albumBuilder.setName(resultSet.getString("NAME"));
			}
		} catch (SQLException exception) {
			albumBuilder = null;
		}
		return albumBuilder;
	}

	/**
	 * Executes {@code sql}.
	 * 
	 * @param sql
	 *            the SQL executed.
	 * @return the {@link ResultSet} of {@code sql}.
	 * @throws SQLException
	 *             rethrown from underlying mechanism.
	 */
	private ResultSet executeQuery(String sql) throws SQLException {

		return getAStatement().executeQuery(sql);
	}

	/**
	 * The query that returns an {@link Album} with {@code id}.
	 * 
	 * @param id
	 *            the id of entity.
	 * @return the sql-query.
	 */
	private String albumQuery(Long id) {

		return String.format("select * from JDBC_ALBUM album where id = %d;", id);
	}

	/**
	 * Returns a {@link Statement}.
	 * 
	 * @return a {@link Statement}.
	 * @throws SQLException
	 *             rethrown from underlying mechanism.
	 */
	private Statement getAStatement() throws SQLException {

		return getAConnection().createStatement();
	}

	/**
	 * Returns the singleton {@link Connection} for this {@link JDBCService}.
	 * 
	 * @return an {@link Connection}.
	 * @throws SQLException
	 *             rethrown from underlying mechanism.
	 */
	private Connection getAConnection() throws SQLException {

		if (connection == null) {
			String url = getJDBCUrl();
			String user = getUser();
			String password = getPassword();
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}

	/**
	 * Returns the JDBC connection url.
	 * 
	 * @return the
	 */
	private String getJDBCUrl() {

		return "jdbc:mysql://localhost:3306/comiccollection";
	}

	/**
	 * Returns the user for the JDBC connection.
	 * 
	 * @return the user.
	 */
	private String getUser() {

		return "comiccollection";
	}

	/**
	 * Returns the password to make a JDBC connection.
	 * 
	 * @return the password.
	 */
	private String getPassword() {

		return "comiccollection";
	}

	/**
	 * Loads the data for the {@link Comic} with {@code id}
	 * 
	 * @param id
	 *            the id for the entity.
	 * @return a data container for the entity.
	 */
	public ComicBuilder loadComicBuilder(Long id) {

		ComicBuilder comicBuilder = new ComicBuilder();
		try {
			ResultSet resultSet = executeQuery(comicQuery(id));
			while (resultSet.next()) {
				comicBuilder.setId(new Long(resultSet.getInt("ID")));
				comicBuilder.setName(resultSet.getString("NAME"));
			}
		} catch (SQLException exception) {
			comicBuilder = null;
		}
		return comicBuilder;
	}

	/**
	 * The query that returns an {@link Comic} with {@code id}.
	 * 
	 * @param id
	 *            the id of entity.
	 * @return the sql-query.
	 */
	private String comicQuery(Long id) {

		return String.format("select * from JDBC_COMIC comic where id = %d;", id);
	}

	/**
	 * Returns a list of ids of {@link Album}s which are contained by the
	 * {@link Comic} with {@code comicId}
	 * 
	 * @param comicId
	 *            the id of the entity.
	 * @return a list of ids.
	 */
	public Collection<Long> getContainedAlbumIDs(Long comicId) {

		Collection<Long> containedAlbumIDs = new HashSet<Long>();
		try {
			ResultSet resultSet = executeQuery(containedAlbumIDsQuery(comicId));
			while (resultSet.next()) {
				containedAlbumIDs.add(new Long(resultSet.getInt("ALBUM_ID")));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return containedAlbumIDs;
	}

	/**
	 * Returns a query that will return the ids of {@link Album}s contained in
	 * the {@link Comic} with {@code comicId}.
	 * 
	 * @param comicId
	 *            the id of the containing entity.
	 * @return a sql-query.
	 */
	private String containedAlbumIDsQuery(Long comicId) {

		return String.format(
				"select contents.ALBUM_ID from JDBC_COMIC_CONTENTS contents where contents.COMIC_ID = %d;", comicId);
	}

	/**
	 * Loads the data for the {@link Omnibus} with {@code id}
	 * 
	 * @param id
	 *            the id for the entity.
	 * @return a data container for the entity.
	 */
	public OmnibusBuilder loadOmnibusBuilder(Long id) {

		OmnibusBuilder omnibusBuilder = new OmnibusBuilder();
		try {
			ResultSet resultSet = executeQuery(omnibusQuery(id));
			while (resultSet.next()) {
				omnibusBuilder.setId(new Long(resultSet.getInt("ID")));
			}
		} catch (SQLException exception) {
			omnibusBuilder = null;
		}
		return omnibusBuilder;
	}

	/**
	 * The query that returns an {@link Omnibus} with {@code id}.
	 * 
	 * @param id
	 *            the id of entity.
	 * @return the sql-query.
	 */
	private String omnibusQuery(Long id) {

		return String.format("select * from JDBC_OMNIBUS comic where id = %d;", id);
	}

	/**
	 * Returns a list of ids of {@link Comic}s which are contained by the
	 * {@link Omnibus} with {@code omnibusId}
	 * 
	 * @param omnibusId
	 *            the id of the entity.
	 * @return a list of ids.
	 */
	public Collection<Long> getContainedComicIDs(Long omnibusId) {

		Collection<Long> containedComicIDs = new HashSet<Long>();
		try {
			ResultSet resultSet = executeQuery(containedComicIDsQuery(omnibusId));
			while (resultSet.next()) {
				containedComicIDs.add(new Long(resultSet.getInt("COMIC_ID")));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return containedComicIDs;
	}

	/**
	 * Returns a query that will return the ids of {@link Comic}s contained in
	 * the {@link Omnibus} with {@code omnibusId}.
	 * 
	 * @param omnibusId
	 *            the id of the containing entity.
	 * @return a sql-query.
	 */
	private String containedComicIDsQuery(Long omnibusId) {

		return String.format(
				"select contents.COMIC_ID from JDBC_OMNIBUS_CONTENTS contents where contents.OMNIBUS_ID = %d;",
				omnibusId);
	}

	/**
	 * Saves or updates {@code album}
	 * 
	 * @param album
	 *            the {@link Album} saved
	 * @return the id of {@code album}.
	 */
	public Long saveOrUpdateAlbum(Album album) {

		if (needToSave(album)) {
			return saveAlbum(album);
		}
		return updateAlbum(album);
	}

	/**
	 * @param entity
	 *            the entity under scrutiny.
	 * @return {@code true} if {@code entity} lacks an id, {@code false}
	 *         otherwise.
	 */
	private boolean needToSave(Identifiable entity) {

		return ArgumentChecker.isNull(entity.getId());
	}

	/**
	 * Saves {@code album} to the database.
	 * 
	 * @param album
	 *            the {@link Album} saved.
	 * @return the id of {@code album}.
	 */
	private Long saveAlbum(Album album) {

		album.setId(getNextId());
		try {
			getAStatement().executeUpdate(getSaveAlbumQuery(album));
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		saveNextId();
		return album.getId();
	}

	/**
	 * Determines the next valid id for this database.
	 * 
	 * @return a unique id,
	 */
	private Long getNextId() {

		if (nextId == null) {
			nextId = loadNextId();
		}
		return nextId++;
	}

	/**
	 * Loads the nextID from the database.
	 * 
	 * @return the nextId
	 */
	private Long loadNextId() {

		Long loadedID = null;
		try {
			ResultSet resultSet = executeQuery(loadNextIdQuery());
			while (resultSet.next()) {
				loadedID = new Long(resultSet.getInt("VALUE"));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return loadedID;
	}

	/**
	 * Returns a query which will load the nextid from the database.
	 * 
	 * @return a sql query.
	 */
	private String loadNextIdQuery() {

		return "select property.VALUE from JDBC_PROPERTY property where property.NAME = 'nextId';";
	}

	/**
	 * Saves the next id to the database.
	 */
	private void saveNextId() {

		try {
			getAStatement().executeUpdate(getSaveNextIDQuery());
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Retursn the query which will save the nextId to the database.
	 * 
	 * @return an sql query.
	 */
	private String getSaveNextIDQuery() {

		return String.format("update JDBC_PROPERTY set VALUE = '%d' where NAME = 'nextId';", nextId);
	}

	/**
	 * The query used to save {@code album}.
	 * 
	 * @param album
	 *            the {@link Album} saved.
	 * @return the query which saves {@code album} to the database.
	 */
	private String getSaveAlbumQuery(Album album) {

		return String.format("insert into JDBC_ALBUM (ID,ALBUMINDEX,NAME) values (%d, %d, '%s');", album.getId(), album
				.getIndex(), album.getName());
	}

	/**
	 * Updates {@code album} in the database.
	 * 
	 * @param album
	 *            the {@link Album} updated.
	 * @return the id of {@code album}.
	 */
	private Long updateAlbum(Album album) {

		try {
			getAStatement().executeUpdate(getUpdateAlbumQuery(album));
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return album.getId();
	}

	/**
	 * The query used to update {@code album}
	 * 
	 * @param album
	 *            the {@link Album} updated.
	 * @return the id of {@code album}.
	 */
	private String getUpdateAlbumQuery(Album album) {

		return String.format("update JDBC_ALBUM set ALBUMINDEX = %d, NAME = '%s' where ID = %d;", album.getIndex(),
				album.getName(), album.getId());
	}

	/**
	 * Saves or updates {@code comic}.
	 * 
	 * @param comic
	 *            the {@link Comic} saved or updated.
	 * @return the id of {@code comic}.
	 */
	public Long saveOrUpdateComic(Comic comic) {

		if (needToSave(comic)) {
			return saveComic(comic);
		}
		return updateComic(comic);
	}

	/**
	 * Saves {@code comic}.
	 * 
	 * @param comic
	 *            the {@link Comic} saved.
	 * @return the id of {@code comic}.
	 */
	private Long saveComic(Comic comic) {

		comic.setId(getNextId());
		try {
			getAStatement().executeUpdate(getSaveComicQuery(comic));
			Collection<Long> albumIDs = saveOrUpdateContainedAlbums(comic);
			saveAlbumContainment(comic, albumIDs);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		saveNextId();
		return comic.getId();
	}

	/**
	 * Returns a query which will save {@code comic}.
	 * 
	 * @param comic
	 *            the {@link Comic} saved.
	 * @return the sql query.
	 */
	private String getSaveComicQuery(Comic comic) {

		return String.format("insert into JDBC_COMIC (ID,NAME) values (%d, '%s');", comic.getId(), comic.getName());
	}

	/**
	 * Saves all contained {@link Album}s of a {@code comic}.
	 * 
	 * @param comic
	 *            the containing {@link Comic}.
	 * @return a {@link Collection} of {@link Album} ids.
	 */
	private Collection<Long> saveOrUpdateContainedAlbums(Comic comic) {

		Collection<Long> albumIDs = new ArrayList<Long>();
		for (Album album : comic.getAlbums()) {
			albumIDs.add(saveOrUpdateAlbum(album));
		}
		return albumIDs;
	}

	/**
	 * Saves the relation between {@code comic} and the containing {@link Album}
	 * s.
	 * 
	 * @param comic
	 *            the containing {@link Comic}.
	 * @param albumIDs
	 *            the ids of the contained {@link Album}.
	 */
	private void saveAlbumContainment(Comic comic, Collection<Long> albumIDs) {

		for (Long albumID : albumIDs) {

			try {
				getAStatement().executeUpdate(getSaveAlbumContainmentQuery(comic.getId(), albumID));
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
	}

	/**
	 * Returns a query which will contain a {@link Album} in a {@link Comic}.
	 * 
	 * @param comicID
	 *            the id of the containing {@link Comic}.
	 * @param albumID
	 *            the id of the contained {@link Album}.
	 * @return the sql query.
	 */
	private String getSaveAlbumContainmentQuery(Long comicID, Long albumID) {

		return String.format("insert into JDBC_COMIC_CONTENTS (COMIC_ID, ALBUM_ID) values (%d, %d);", comicID, albumID);
	}

	/**
	 * Updates {@code comic}.
	 * 
	 * @param comic
	 *            the {@link Comic} updated.
	 * @return the id of {@code comic}.
	 */
	private Long updateComic(Comic comic) {

		try {
			getAStatement().executeUpdate(getUpdateComicQuery(comic));
			Collection<Long> albumIDs = saveOrUpdateContainedAlbums(comic);
			updateAlbumContainment(comic, albumIDs);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return comic.getId();
	}

	/**
	 * Returns the query which will update {@code comic}.
	 * 
	 * @param comic
	 *            the {@link Comic} updated.
	 * @return the sql query.
	 */
	private String getUpdateComicQuery(Comic comic) {

		return String.format("update JDBC_COMIC set NAME = '%s' where ID = %d;", comic.getName(), comic.getId());
	}

	/**
	 * Updates the {@link Album}s that are contained by {@code comic}.
	 * 
	 * @param comic
	 *            the {@link Comic} which will get updated.
	 * @param albumIDs
	 *            the ids which will get updated.
	 */
	private void updateAlbumContainment(Comic comic, Collection<Long> albumIDs) {

		clearAlbumContainment(comic);
		saveAlbumContainment(comic, albumIDs);
	}

	/**
	 * Removes the relation between a {@link Comic} and het {@link Album}s.
	 * 
	 * @param comic
	 *            the {@link Comic} which will be cleared.
	 */
	private void clearAlbumContainment(Comic comic) {

		try {
			getAStatement().executeUpdate(getClearAlbumContaintmentQuery(comic));
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Returns the query which will remove the relation between a {@link Comic}
	 * and her {@link Album}s
	 * 
	 * @param comic
	 *            the {@link Comic} which will be cleared.
	 * @return the sql query.
	 */
	private String getClearAlbumContaintmentQuery(Comic comic) {

		return String.format("delete from JDBC_COMIC_CONTENTS where COMIC_ID = %d", comic.getId());
	}

	/**
	 * Saves or updates {@code omnibus}.
	 * 
	 * @param omnibus
	 *            the {@link Omnibus} saved.
	 * @return the id of {@code omnibus}.
	 */
	public Long saveOrUpdateOmnibus(Omnibus omnibus) {

		if (needToSave(omnibus)) {
			return saveOmnibus(omnibus);
		}
		return updateOmnibus(omnibus);
	}

	/**
	 * Saves the {@code omnibus}.
	 * 
	 * @param omnibus
	 *            the {@link Omnibus} saved.
	 * @return the id of {@code omnibus}.
	 */
	private Long saveOmnibus(Omnibus omnibus) {

		omnibus.setId(getNextId());
		try {
			getAStatement().executeUpdate(getSaveOmnibusQuery(omnibus));
			Collection<Long> comicIDs = saveOrUpdateContainedComics(omnibus);
			saveComicContainment(omnibus, comicIDs);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		saveNextId();
		return omnibus.getId();
	}

	/**
	 * Returns the query which will save the {@code omnibus}.
	 * 
	 * @param omnibus
	 *            the {@link Omnibus} saved.
	 * @return the sql query.
	 */
	private String getSaveOmnibusQuery(Omnibus omnibus) {

		return String.format("insert into JDBC_OMNIBUS (ID) values (%d);", omnibus.getId());
	}

	/**
	 * Save of update the contained {@link Comic}s of {@code omnibus}.
	 * 
	 * @param omnibus
	 *            the contianer {@link Omnibus}.
	 * @return the id of the contained {@link Comic}s.
	 */
	private Collection<Long> saveOrUpdateContainedComics(Omnibus omnibus) {

		Collection<Long> comicIDs = new ArrayList<Long>();
		for (Comic comic : omnibus.getComics()) {
			comicIDs.add(saveOrUpdateComic(comic));
		}
		return comicIDs;
	}

	/**
	 * Saves the associations between {@code omnibus} and the containing
	 * {@link Comic}s.
	 * 
	 * @param omnibus
	 *            the container {@link Omnibus}.
	 * @param comicIDs
	 *            the ids of the contained {@link Comic}s.
	 */
	private void saveComicContainment(Omnibus omnibus, Collection<Long> comicIDs) {

		for (Long comicID : comicIDs) {

			try {
				getAStatement().executeUpdate(getSaveComicContainmentQuery(omnibus.getId(), comicID));
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
	}

	/**
	 * Returns the query to save the {@link Comic}s contained by the
	 * {@link Omnibus}.
	 * 
	 * @param omnibusID
	 *            the id of the {@link Omnibus}.
	 * @param comicID
	 *            the id of the {@link Comic} contained by the {@link Omnibus}.
	 * @return the sql query.
	 */
	private String getSaveComicContainmentQuery(Long omnibusID, Long comicID) {

		return String.format("insert into JDBC_OMNIBUS_CONTENTS (OMNIBUS_ID,COMIC_ID) values (%d, %d);", omnibusID,
				comicID);
	}

	/**
	 * Updates the {@code omnibus}.
	 * 
	 * @param omnibus
	 *            the {@link Omnibus} updated.
	 * @return the id of {@code omnibus}.
	 */
	private Long updateOmnibus(Omnibus omnibus) {

		Collection<Long> comicIDs = saveOrUpdateContainedComics(omnibus);
		updateComicContainment(omnibus, comicIDs);
		return omnibus.getId();
	}

	/**
	 * Updates associated {@link Comic} of {@code omnibus}.
	 * 
	 * @param omnibus
	 *            the {@link Omnibus} updated.
	 * @param comicIDs
	 *            the id of the {@link Comic}s contained by {@code omnibus}.
	 */
	private void updateComicContainment(Omnibus omnibus, Collection<Long> comicIDs) {

		clearComicContainment(omnibus);
		saveComicContainment(omnibus, comicIDs);
	}

	/**
	 * Cleaar the association with {@code omnibus} and contained {@link Comic}s.
	 * 
	 * @param omnibus
	 *            the {@link Omnibus} purged.
	 */
	private void clearComicContainment(Omnibus omnibus) {

		try {
			getAStatement().executeUpdate(getClearComicContaintmentQuery(omnibus));
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Returns the query which will remove the association between {@code
	 * omnibus} and {@Link Comics};
	 * 
	 * @param omnibus
	 *            the {@link Omnibus} purged.
	 * @return the sql query.
	 */
	private String getClearComicContaintmentQuery(Omnibus omnibus) {

		return String.format("delete from JDBC_OMNIBUS_CONTENTS where COMIC_ID = %d", omnibus.getId());
	}

	/**
	 * Returns a collection which could build all the {@link Omnibus}ses.
	 * 
	 * @return a collection of {@link OmnibusBuilder}s.
	 */
	public Collection<OmnibusBuilder> loadAllOmnibusBuilders() {

		Collection<OmnibusBuilder> omnibusBuilders = new HashSet<OmnibusBuilder>();
		for (Long omnibusId : loadAllOmnibusIDs()) {

			omnibusBuilders.add(loadOmnibusBuilder(omnibusId));
		}
		return omnibusBuilders;
	}

	/**
	 * Returns the ids of all the {@link Omnibus}ses.
	 * 
	 * @return a collection of ids.
	 */
	private Collection<Long> loadAllOmnibusIDs() {

		Collection<Long> omnibusIDs = new HashSet<Long>();
		try {
			ResultSet resultSet = executeQuery(allOmnibusIDsQuery());
			while (resultSet.next()) {
				omnibusIDs.add(new Long(resultSet.getInt("ID")));
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return omnibusIDs;
	}

	/**
	 * Returns a query which will load all the ids of {@link Omnibus}ses.
	 * 
	 * @return a sql query.
	 */
	private String allOmnibusIDsQuery() {

		return "select omnibus.ID from JDBC_OMNIBUS omnibus;";
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {

		super.finalize();
		getAConnection().close();
	}

	/**
	 * @return the properties
	 */
	private Properties getProperties() {

		return properties;
	}

	/**
	 * @param properties
	 *            the properties to set
	 */
	private void setProperties(Properties properties) {

		this.properties = properties;
	}
}
