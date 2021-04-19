package BussinessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Controller.DataPreProcess;
import DatabaseLayer.MySQLConnection;
import Model.Order;
import Model.Stock;
import Model.User;

public class BuyOrder extends MySQLConnection implements Order{
	private static Connection conn;
	@Override
	public void marketOrder(int id , String investmentType ,String orderType, String orderOption , Scanner s ) {
		if(conn==null) conn = establishConnection();
		double balance = 0;
		double price = 0;
		String symbol ="";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select balance from users where id=" + id);
			rs.next();
			balance = rs.getFloat(1);
		}	catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("Available Balance: "+  Math.round(balance * 100D) / 100D);
		System.out.println("Enter the Stock ID ->");
		int stockid = s.nextInt();
		s.nextLine();
	
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select symbol , LTP from stock where stockid=" + stockid);
			rs.next();
			price = rs.getDouble(2);
			symbol = rs.getString(1);
			System.out.println("Last Traded Stock Price : "+price);
		
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("Enter the QTY ->");
		int qty = s.nextInt();
	
		double totalPrice = qty*price;
		System.out.println("Total Price : "+ totalPrice );
		s.nextLine();
		if(totalPrice > balance && !orderOption.equalsIgnoreCase("Selling")) {
			System.out.println("===================Error: Not Available Balance===================");
		}
		else {
			try {
			if(orderOption.equalsIgnoreCase("Selling")) {
				double newBal = balance + totalPrice;
				PreparedStatement pt = conn.prepareStatement("UPDATE USERS SET balance = (?) where id =(?);");
				pt.setDouble(1, newBal);
				pt.setInt(2, id);
				pt.execute();
			}
			else {
				double newBal = balance - totalPrice;
				PreparedStatement pt = conn.prepareStatement("UPDATE USERS SET balance = (?) where id =(?);");
				pt.setDouble(1, newBal);
				pt.setInt(2, id);
				pt.execute();
			}
			Statement stmt=(Statement) conn.createStatement();  
			ResultSet rs=stmt.executeQuery("select count(id) from orders;");  
			rs.next();
			int size = rs.getInt(1) +1;
			PreparedStatement pt = conn.prepareStatement("INSERT INTO ORDERS(id , user_id , stock_name , investment_type , order_type , order_option,qty, order_date) VALUES(?,?,?,?,?,?, ?, CURRENT_TIMESTAMP)");
			pt.setInt(1, size);
			pt.setInt(2, id);
			pt.setString(3, symbol);
			pt.setString(4, investmentType);	pt.setString(5, orderType);	pt.setString(6, orderOption);
			pt.setInt(7, qty);
			int res = pt.executeUpdate();
			if(res==1) {
				System.out.println("===================Order Successfull===================");
			}else {
				System.out.println("===================Order Unsuccessfull===================");

			}
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	
	}

	@Override
	public void limitOrder(int id , String investmentType ,String orderType, String orderOption , Scanner s ) {
		User usr  = DataPreProcess.getUserById(id);
		s.nextLine();
		System.out.println("Available Balance: "+ usr.getBalance());
		System.out.println("Enter the Stock ID ->");
		int stockid = s.nextInt();
		s.nextLine();
		Stock st =DataPreProcess.getStockById(stockid);
		System.out.println("Last Traded Stock Price : "+st.getLastTradedPrice());
		System.out.println("Enter the QTY ->");
		int qty = s.nextInt();
		s.nextLine();
		System.out.println("Enter the Price:");
		double price = s.nextDouble();
		s.nextLine();
		double totalPrice = qty*price;
		System.out.println("Total Price : "+ totalPrice );
		if(totalPrice > usr.getBalance() && !orderOption.equalsIgnoreCase("Selling")) {
			System.out.println("===================Error: Not Available Balance===================");
		}
		else {
			if(orderOption.equalsIgnoreCase("Selling"))usr.setBalance(usr.getBalance() + totalPrice);
			else usr.setBalance(usr.getBalance() - totalPrice);
			int size  = usr.getOrders().size()+1;
			usr.setStocks(st, qty, orderOption);
			usr.addOrder(size, st.getSymbol(), investmentType,orderType, orderOption, price,qty);
		}
	}

	@Override
	public void bracketOrder(int id , String investmentType ,String orderType, String orderOption , Scanner s) {
		User usr  = DataPreProcess.getUserById(id);
		s.nextLine();
		System.out.println("Available Balance: "+ usr.getBalance());
		System.out.println("Enter the Stock ID ->");
		int stockid = s.nextInt();
		s.nextLine();
		Stock st =DataPreProcess.getStockById(stockid);
		System.out.println("Last Traded Stock Price : "+st.getLastTradedPrice());

		System.out.println("Enter the Price:");
		double price = s.nextDouble();
		s.nextLine();
		System.out.println("Enter the QTY ->");
		int qty = s.nextInt();
		
		double totalPrice = qty*price;
		System.out.println("Total Price : "+ totalPrice );
		if(totalPrice > usr.getBalance()) {
			System.out.println("===================Error: Not Available Balance===================");
		}
		else {
			if(orderOption.equalsIgnoreCase("Selling"))usr.setBalance(usr.getBalance() + totalPrice);
			else usr.setBalance(usr.getBalance() - totalPrice);
			int size  = usr.getOrders().size()+1;
			usr.setStocks(st, qty, orderOption);
			usr.addOrder(size, st.getSymbol(), investmentType,orderType, orderOption, price,qty);
			s.nextLine();
			System.out.println("Enter the Target Price:");
			double targetPrice = s.nextDouble();s.nextLine();
			System.out.println("Enter the Stoploss Price:");
			double stopLoss = s.nextDouble();s.nextLine();
			SellOrder.limitOrder(usr, st, qty, investmentType, orderType, orderOption, targetPrice, stopLoss);
		}
		
		

		
	}

}
