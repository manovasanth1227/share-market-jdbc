package Controller;


import java.util.Scanner;

import BussinessLogic.BuyOrder;

public class OrderController extends BuyOrder {
	public static void buyOrder(int id , String investmentType ,String orderType, String orderOption , Scanner s) {
		BuyOrder obj = new BuyOrder();
		System.out.println("-------------------INVESTMENT-"+ investmentType+"===="+" "+orderOption+"==="+orderType+"-------------------");
		if(orderType.equalsIgnoreCase("market")) {
			obj.marketOrder(id,investmentType,orderType,orderOption,s);
		}else if(orderType.equalsIgnoreCase("limit")) {
			obj.limitOrder(id, investmentType, orderType, orderOption, s);
		}else if(orderType.equalsIgnoreCase("bracket")) {
			obj.bracketOrder(id, investmentType, orderType, orderOption, s);
		}else {
			System.out.println("===================Error:Enter Details Correctly===================");
		}
	}
}
