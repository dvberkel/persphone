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
import org.effrafax.comiccollection.persistence.jdbc.dto.AlbumDTO;
import org.effrafax.comiccollection.persistence.jdbc.dto.ComicDTO;

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
	 *            the id of {@link Album}.
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

	private String comicQuery(Long id) {

		return String.format("select * from JDBC_COMIC comic where id = %d;", id);
	}

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

	private String containedAlbumIDsQuery(Long comicId) {

		return String.format(
				"select contents.ALBUM_ID from JDBC_COMIC_CONTENTS contents where contents.COMIC_ID = %d;", comicId);
	}

}
