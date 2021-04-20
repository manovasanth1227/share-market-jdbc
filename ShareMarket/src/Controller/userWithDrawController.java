package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DatabaseLayer.MySQLConnection;


public class userWithDrawController extends MySQLConnection {
	private static Connection conn;
		public static void withDraw(int id ,double amt,  double balance) {
			if(conn==null) conn = establishConnection();
			int res =0;
			try {
				PreparedStatement pt = conn.prepareStatement("UPDATE USERS SET balance = (?) where id =(?);");
				pt.setDouble(1, balance -  amt);
				pt.setInt(2, id);
				res = pt.executeUpdate();
			}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			if(res==1) {
				System.out.println("===================Withdraw Successfull===================");
			}else {
				System.out.println("===================Withdraw Unsuccessfull===================");
			}
				
		}
}
