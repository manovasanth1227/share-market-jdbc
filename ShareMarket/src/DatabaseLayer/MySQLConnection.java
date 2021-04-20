package DatabaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConnection {
	private static final String className = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/sharemarket";
	private static final String password = "root";
	private static final String UID = "root";
	private static Connection conn;
	public static Connection establishConnection() {
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(URL, UID, password);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
