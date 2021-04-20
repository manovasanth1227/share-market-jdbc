package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseLayer.MySQLConnection;

public class userStocksController extends MySQLConnection{
	private static Connection conn;
	
	public static void getUserStocks(int id) {
		if(conn==null) conn = establishConnection();
		int f =0;
		try {
			Statement st = conn.createStatement();
			ResultSet rs  =st.executeQuery("select * from user_stock where user_id = "+id);  
			while(rs.next()) {
				f=1;
				System.out.println("StockID : " + rs.getInt(1)+ " Stock Name : " + rs.getString(3) + " QTY : " + rs.getInt(4));
			}
			if(f==0) {
				System.out.println("===================No stocks available===================");
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
