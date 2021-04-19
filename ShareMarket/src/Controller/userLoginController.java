package Controller;

import java.util.Scanner;

import BussinessLogic.userAuthentication;
import View.ShareMarketDriver;

public class userLoginController extends userAuthentication{
	public static boolean loginController(Scanner s) {
		while(true){
				System.out.println("-------------------Login-------------------");
				System.out.println("Enter Your UserId (Number) ->");
				try {
					int id = s.nextInt();
				
				
				 System.out.println("Enter Your UserName ->");s.nextLine();
				 String name =s.nextLine();
				 System.out.println("Enter Password ->");
				 String password = s.nextLine();
				 if(userAuthentication.validateCredentials(id, name, password)) {
					 System.out.println("===================Login Successfull===================");
					 ShareMarketDriver.setUsrId(id);
					 return true;
				 }else {
					 System.out.println("===================Invalid Credentials===================");
					 System.out.println("Dashboard y/n ->");
					 String ch = s.nextLine();
					 if(ch.charAt(0)=='y' ||ch.charAt(0)=='Y') {
						 return false;
					 }
				 }
				}
				catch(Exception e) {
					 System.out.println("===================Invalid Credentials===================");
				
					 String ch = s.nextLine();
					 if(ch.charAt(0)=='y' ||ch.charAt(0)=='Y') {
						 return false;
					 }
				}
			
				
			
		}
	}
}
