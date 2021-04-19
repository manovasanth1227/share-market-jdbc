package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseLayer.MySQLConnection;

public class userOrderHistory extends MySQLConnection  {
	private static Connection conn;
	public static void getHistory(int id) {
		if(conn==null)conn = establishConnection();
		int f =0;
		try {
			Statement st =conn.createStatement();
			ResultSet rs = st.executeQuery("select * from orders where user_id="+id);
			while(rs.next()) {
				f =1;
				System.out.println("Order ID : " + rs.getInt(1) + " Stock Symbol : " +  rs.getString(3) + " Investment-Type : " + rs.getString(4) + "Order Type : " + rs.getString(5) + " BUY?SELL : " + rs.getString(6) + " Quantity : " + rs.getInt(7) + " Order Date : "  + rs.getDate(8)   );
			}
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(f==0) {
			System.out.println("===================No Orders Available===================");
		}
	}
}
