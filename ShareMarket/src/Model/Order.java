package Model;

import java.util.Scanner;

public interface Order {
	public void marketOrder(int id , String investmentType ,String orderType, String orderOption , Scanner s );
	public void limitOrder(int id , String investmentType ,String orderType, String orderOption , Scanner s );
	public void bracketOrder(int id , String investmentType ,String orderType, String orderOption , Scanner s);
}
