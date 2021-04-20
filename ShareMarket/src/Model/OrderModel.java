package Model;
import java.time.LocalDateTime;
public class OrderModel {
	private int id;
	private String stockName;
	private String investmentType;
	private String orderType;
	private String orderOption;
	private LocalDateTime date;
	private int qty;
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	private double tradePrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInvestmentType() {
		return investmentType;
	}
	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public OrderModel(int id,String stockName, String investmentType, String orderType, String orderOption,LocalDateTime date, double tradePrice, int qty) {
		super();
		this.id = id;
		this.stockName = stockName;
		this.orderOption = orderOption;
		this.investmentType = investmentType;
		this.orderType = orderType;
		this.qty = qty;
		this.date = date;
		this.tradePrice = tradePrice;
	}
	@Override
	public String toString() {
		return "OrderModel [id=" + id +", stockName="+stockName+ ", investmentType=" + investmentType + ", orderType=" + orderType + ", orderOption="+orderOption+", date="
				+ date + ", Quantity="+qty+", tradePrice=" + tradePrice + "]";
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getOrderOption() {
		return orderOption;
	}
	public void setOrderOption(String orderOption) {
		this.orderOption = orderOption;
	}
	public double getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(double tradePrice) {
		this.tradePrice = tradePrice;
	}
	
	
}
