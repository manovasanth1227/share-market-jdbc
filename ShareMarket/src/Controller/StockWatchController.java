package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DatabaseLayer.MySQLConnection;
import Model.Stock;
public class StockWatchController extends MySQLConnection {

	private static Connection conn;
	public static void stockDisplay() {
		if(conn==null)conn = establishConnection();
		
		try {
			Statement stmt=(Statement) conn.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from stock");  
			while(rs.next()) {
				int id = rs.getInt(1);
				String symbol = rs.getString(2);
				String name = rs.getString(3);
				double LTP =  Math.round(rs.getFloat(4) * 100D) / 100D; 
				String sectorName = rs.getString(5);
				int volume  = rs.getInt(6);
			
				DataPreProcess.addStock(new Stock(id , symbol , name , LTP, sectorName , volume + ""));
				System.out.println("ID : "+id + " SYMOBOL : "+ symbol + " NAME : " +name+" LAST TRADED PRICE : " +LTP + " SECTOR NAME : "+ sectorName +  " VOLUME : " +volume);
			}
			conn.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	
	}
}
