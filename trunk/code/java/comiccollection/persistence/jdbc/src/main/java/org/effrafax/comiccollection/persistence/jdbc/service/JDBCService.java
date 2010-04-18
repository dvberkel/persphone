/**
 * 
 */
package org.effrafax.comiccollection.persistence.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.persistence.jdbc.dto.AlbumDTO;
import org.effrafax.comiccollection.persistence.jdbc.dto.ComicDTO;
import org.effrafax.comiccollection.persistence.jdbc.dto.OmnibusDTO;

/**
 * @author dvberkel
 */
public class JDBCService {

	/**
	 * The singleton connection with the database.
	 */
	private Connection connection = null;

	/**
	 * The constructor for this {@link JDBCService}
	 */
	public JDBCService() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException exception) {
			throw new IllegalStateException(exception);
		}
	}

	/**
	 * Loads an {@link AlbumDTO} from the databas.
	 * 
	 * @param id
	 *            the id of the corresponding {@link Album}.
	 * @return an {@link AlbumDTO}.
	 */
	public AlbumDTO loadAlbumDTO(Long id) {

		AlbumDTO albumDTO = new AlbumDTO();
		try {
			ResultSet resultSet = executeQuery(albumQuery(id));
			while (resultSet.next()) {
				albumDTO.setId(new Long(resultSet.getInt("ID")));
				albumDTO.setIndex(new Integer(resultSet.getInt("ALBUMINDEX")));
				albumDTO.setName(resultSet.getString("NAME"));
			}
		} catch (SQLException exception) {
			albumDTO = null;
		}
		return albumDTO;
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
			String url = "jdbc:mysql://localhost:3306/comiccollection";
			String user = "comiccollection";
			String password = "comiccollection";
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
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
	 * Loads the data for the {@link Comic} with {@code id}
	 * 
	 * @param id
	 *            the id for the entity.
	 * @return a data container for the entity.
	 */
	public ComicDTO loadComicDTO(Long id) {

		ComicDTO comicDTO = new ComicDTO();
		try {
			ResultSet resultSet = executeQuery(comicQuery(id));
			while (resultSet.next()) {
				comicDTO.setId(new Long(resultSet.getInt("ID")));
				comicDTO.setName(resultSet.getString("NAME"));
			}
		} catch (SQLException exception) {
			comicDTO = null;
		}
		return comicDTO;
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
			/* For now we will return an empty list */
			// TODO add proper error handling.
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
	public OmnibusDTO loadOmnibusDTO(Long id) {

		OmnibusDTO omnibusDTO = new OmnibusDTO();
		try {
			ResultSet resultSet = executeQuery(omnibusQuery(id));
			while (resultSet.next()) {
				omnibusDTO.setId(new Long(resultSet.getInt("ID")));
			}
		} catch (SQLException exception) {
			omnibusDTO = null;
		}
		return omnibusDTO;
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
			/* For now we will return an empty list */
			// TODO add proper error handling.
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

}
