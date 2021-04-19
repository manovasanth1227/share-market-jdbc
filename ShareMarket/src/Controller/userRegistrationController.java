package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DatabaseLayer.MySQLConnection;
public class userRegistrationController extends MySQLConnection  {
	private static Connection conn;
	public static void createUser(Scanner s)  {
		while(true) {
			 System.out.println("-------------------Registration-------------------");
			 System.out.println("Enter Your Name ->");
			 s.nextLine();
			 String userName = s.nextLine();
			 System.out.println("Enter Your Adhar card number ->");
			 String userAdharCard = s.nextLine();
			 if(userAdharCard.length()!=12) {
				 System.out.println("===================Error:Please Check Your Adhar card number (Should be a 12 Digit Number)===================");
				 continue;
			 }
			 System.out.println("Enter Your PAN card number ->");
			 String userPanCard = s.nextLine();
			 System.out.println("Enter Your Bank Account");
			 String userBankAccount  = s.nextLine();
			 System.out.println("Enter Password(Should contain atleast one LowerCase, UpperCase, Special Character, Number)");
			 String userPassword = s.nextLine();
			 if (userPassword.length()<8) 
               {
                   System.out.println("Password must have at least 8 characters");
                   continue;
               }
			 else {
				 	if(conn==null)conn = establishConnection();
				 	int id = 0;
				 	int newid=0;
				 	try {
						Statement stmt=(Statement) conn.createStatement();  
						ResultSet rs=stmt.executeQuery("select count(id) from users;");  
						rs.next();
						id = rs.getInt(1);
						PreparedStatement pt = conn.prepareStatement("insert into users(id, user_name , password, bank,adhar_card,pan_card) values(?,?,?,?,?,?)");
						pt.setInt(1, id+1);
						pt.setString(2, userName);
						pt.setString(3, userPassword);
						pt.setString(4, userBankAccount);
						pt.setString(5, userAdharCard);
						pt.setString(6, userPanCard);
						pt.executeUpdate();
						rs = stmt.executeQuery("select count(id) from users;");
						rs.next();
						newid = rs.getInt(1);
					}
					catch (SQLException e1) {
							e1.printStackTrace();
					}
					if(id+1 == newid) {
						 System.out.println("===================Registration Successfull===================");
						 System.out.println("===================Your User ID: " +(id+1) +"===================");
						break;
					}else {
						System.out.println("===================Error:Enter Details Correctly===================");
						 System.out.println("Dashboard y/n ->");
						 String ch = s.nextLine();
						 if(ch.charAt(0)=='y' ||ch.charAt(0)=='Y') {
							 break;
						 }
					}
			 }
		 }
	}
}
