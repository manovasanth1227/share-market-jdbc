package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import DatabaseLayer.MySQLConnection;


public class userDepositController extends MySQLConnection {
	static Connection conn;
	public static void deposit(double amt, int id,double balance) {
		if(conn==null) conn = establishConnection();
		int res =0;
		try {
			PreparedStatement pt = conn.prepareStatement("UPDATE USERS SET balance = (?) where id =(?);");
			pt.setDouble(1, balance + amt);
			pt.setInt(2, id);
			res = pt.executeUpdate();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(res==1) {
			System.out.println("===================Deposit Successfull===================");
		}else {
			System.out.println("===================Deposit Unsuccessfull===================");
		}
			
	}
}
