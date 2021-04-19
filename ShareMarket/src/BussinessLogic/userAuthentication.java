package BussinessLogic;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseLayer.MySQLConnection;


public class userAuthentication extends MySQLConnection {
	private static Connection conn;
	public static  boolean validateCredentials(int id , String userName, String password) {
			if(conn==null) conn = establishConnection();
			try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select user_name, password from users where id=" + id);
				if(rs.next()) {
						if( rs.getString(1).equalsIgnoreCase(userName) && rs.getString(2).equalsIgnoreCase(password)) {
							return true;
						}
				}
				return false;	
			}catch (SQLException e1) {
				e1.printStackTrace();
		  }
			return false;
		
		}
}
