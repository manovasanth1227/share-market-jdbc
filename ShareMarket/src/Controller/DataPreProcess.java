package Controller;

import java.util.ArrayList;
import Model.Stock;
import Model.User;

public class DataPreProcess {
	private static ArrayList<Stock> stock = new ArrayList<Stock>();
	private static ArrayList<User> user = new ArrayList<>();
	
	
	public static void  createUsers() {
		user.add(new User(1,"qwerty1Q#","ICICI","123456789012", "edfgfdhv098","Manovasanth Balasankar"));
		user.add( new User(2,"asdfgh2A#","SBI","098765432112", "kgucfxyyhv238","Balasankar"));
	
	}
	public static User getUserById(int id) {
		for(User usr : user) {
			if(usr.getUserId()==id) {
				return usr;
			}
		}
		return null;
		
	}


	public static ArrayList<User> getUsers() {
		return user;
	}
	public static void setUser( int id, String userName , String userPassword, String userBankAccount, String userAdharCard, String userPanCard) {
			user.add(new User(id,userPassword,userBankAccount,userAdharCard,userPanCard,userName));
	}
	public static ArrayList<Stock> getStocks() {
		return stock;
	}
	
	public static Stock getStockById(int id) {
		for(Stock st:stock) {
			if(st.getId()==id) {
				return st;
			}
		}
		return null;
	}
	public static void addStock(Stock st) {
		stock.add(st);
	}
	
	
}
