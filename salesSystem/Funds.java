package salesSystem;

public class Funds {
	private double money;
	private double profit;
	private double totalProfit;
	private double totalSales;
	private double bid;
	private double averageBid;
	
	public Funds(double money){
		this.money = money;
	}
	
	public double getMoney() {
		return money;
	}
	
	
	public void expense(double expense){
		money -= expense;
	}

	public double getTotalSales() {
		return totalSales;
	}

	public double getTotalProfit() {
		return totalProfit;
	}

	public void addTotalProfit(double addtotal) {
		this.totalProfit += addtotal;
	}

	public void addTotalSales(double addTotal) {
		this.totalSales += addTotal;
	}
	
	public void addFunds(double add){
		money += add;
	}
	
	

}
