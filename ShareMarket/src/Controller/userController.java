package Controller;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DatabaseLayer.MySQLConnection;

public class userController extends MySQLConnection {
	private static Connection conn;
	public static void deposit(int id, Scanner s) {
		double balance = 0;
		if(conn==null) conn = establishConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select balance from users where id=" + id);
			rs.next();
			balance = rs.getFloat(1);
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("-------------------Deposit-------------------");
		System.out.println("Available Balance : " + Math.round(balance * 100D) / 100D);
		System.out.println("Enter Amount to be Deposited ->");
		double amt  = s.nextDouble();
		s.nextLine();
		userDepositController.deposit(amt,id,balance);
	}
	public static void withDraw(int id, Scanner s) {
		double balance = 0;
		if(conn==null) conn = establishConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select balance from users where id=" + id);
			rs.next();
			balance = rs.getFloat(1);
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("-------------------Deposit-------------------");
		System.out.println("Available Balance : " +Math.round(balance * 100D) / 100D);
		System.out.println("Enter Amount to Withdraw ->");
		double amt  = s.nextDouble();
		s.nextLine();
		if(amt < balance)userWithDrawController.withDraw(id, amt,balance);
		else {
			System.out.print("-------------------Over Draft-------------------");
		}
	}
	public static void viewBalance(int id, Scanner s) {
		double balance = 0;
		if(conn==null) conn = establishConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select balance from users where id=" + id);
			rs.next();
			balance = rs.getFloat(1);
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("-------------------View Balance-------------------");
		System.out.println("Available Balance : " + Math.round(balance * 100D) / 100D);
	}
}
