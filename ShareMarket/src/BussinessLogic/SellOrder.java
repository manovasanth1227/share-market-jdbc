package BussinessLogic;


import Model.Stock;
import Model.User;

public class SellOrder {
	
	public static void limitOrder(User usr, Stock st, int qty, String investmentType ,String orderType, String orderOption, double targetPrice , double stopLoss) {
		if(orderOption.equalsIgnoreCase("Buying")){
			int size  = usr.getOrders().size()+1;

			usr.addOrder(size, st.getSymbol(), investmentType,orderType, orderOption, targetPrice,qty);
			usr.addOrder(size+1, st.getSymbol(), investmentType,orderType,"Selling", stopLoss,qty);
		}else if(orderOption.equalsIgnoreCase("Selling")) {
			int size  = usr.getOrders().size()+1;

			usr.addOrder(size, st.getSymbol(), investmentType,orderType, orderOption, targetPrice,qty);
			usr.addOrder(size+1, st.getSymbol(), investmentType,orderType,"Buying", stopLoss,qty);
		}
		
		
	}

}
