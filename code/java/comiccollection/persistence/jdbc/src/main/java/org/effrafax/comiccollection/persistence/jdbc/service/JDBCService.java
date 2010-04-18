/**
 * 
 */
package org.effrafax.comiccollection.persistence.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.persistence.jdbc.dto.AlbumDTO;

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

}
