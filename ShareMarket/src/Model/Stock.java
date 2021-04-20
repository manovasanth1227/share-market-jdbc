package Model;

public class Stock {
	private int id;
	private String symbol;
	private String name;
	private double lastTradedPrice;
	private String sectorName;
	private String volume;
	public Stock(int id , String symbol, String name, double lastTradedPrice, String sectorName, String volume) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.name = name;
		this.lastTradedPrice = lastTradedPrice;
		this.sectorName = sectorName;
		this.volume = volume;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Stock [ID= "+id+" SYMBOL=" + symbol + ", NAME=" + name + ", lastTradedPrice=" + lastTradedPrice + ", SECTORNAME="
				+ sectorName + ", VOLUME=" + volume + "]";
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLastTradedPrice() {
		return lastTradedPrice;
	}
	public void setLastTradedPrice(double lastTradedPrice) {
		this.lastTradedPrice = lastTradedPrice;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
}
