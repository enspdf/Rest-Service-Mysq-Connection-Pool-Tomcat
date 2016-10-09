package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConnectionDatabase {

	Connection connection;

	public Connection getConnection() throws Exception {

		try {
			/*String connectionURL = "jdbc:mysql://localhost:3306/ws";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "root");
			return connection;*/
			javax.naming.InitialContext c = new javax.naming.InitialContext();
			DataSource ds = (DataSource) c.lookup("java:comp/env/jdbc/wsConnection");
			connection = ds.getConnection();
			return connection;
		} catch (Exception e) {
			throw e;
		}

	}

	public void closeResources() throws SQLException {
		if (connection != null) {
			if (!connection.isClosed()) {
				connection.close();
			}
		}
	}

}
