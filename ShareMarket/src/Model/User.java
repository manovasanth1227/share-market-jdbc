package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
	private int userId;
	private String userPassword;
	private String userBankAccount;
	private String userAdharCard;
	private String userPanCard;
	private String userName;
	private double balance;
	private HashMap<Stock,Integer> stocks = new HashMap<Stock,Integer>();
	private  ArrayList<OrderModel> order = new ArrayList<>();
	
	public int getUserId() {
		return userId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public HashMap<Stock, Integer> getStocks() {
		return stocks;
	}
	public void setStocks(Stock stock , int qty, String option) {
		if(this.stocks.containsKey(stock)) {
			if(option.equalsIgnoreCase("Buying")) {
				this.stocks.put(stock,this.stocks.get(stock) + qty);
			}else if(option.equalsIgnoreCase("Selling")) {
				this.stocks.put(stock,this.stocks.get(stock) - qty);
			}
		}
		else this.stocks.put(stock,qty);
	}
	public User() {
		
	}
	public void addOrder(int id,String stockName, String investmentType, String orderType,String orderOption, double tradePrice, int qty) {
		LocalDateTime date = LocalDateTime.now();
		order.add(new OrderModel(id,  stockName, investmentType,orderType, orderOption, date ,tradePrice,qty));
	}
	public  ArrayList<OrderModel> getOrders() {
		return order;
	}


	public User(int userId, String userPassword, String userBankAccount, String userAdharCard, String userPanCard,
			String userName) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userBankAccount = userBankAccount;
		this.userAdharCard = userAdharCard;
		this.userPanCard = userPanCard;
		this.balance = 0.0;
		this.userName = userName;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserBankAccount() {
		return userBankAccount;
	}
	public void setUserBankAccount(String userBankAccount) {
		this.userBankAccount = userBankAccount;
	}
	public String getUserAdharCard() {
		return userAdharCard;
	}
	public void setUserAdharCard(String userAdharCard) {
		this.userAdharCard = userAdharCard;
	}
	public String getUserPanCard() {
		return userPanCard;
	}
	public void setUserPanCard(String userPanCard) {
		this.userPanCard = userPanCard;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userFullName) {
		this.userName = userFullName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + ", userBankAccount=" + userBankAccount
				+ ", userAdharCard=" + userAdharCard + ", userPanCard=" + userPanCard + ", userName=" + userName
				+ ", balance=" + balance + ", stocks=" + stocks + "]";
	}
	
	
	
	
	
	
}
