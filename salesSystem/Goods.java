package salesSystem;

public class Goods {
	private String Name;
	private int totalAmount;
	private double Price;
	private double bid;
	private int left;
	private double averageBid;
	private int totalNumOfGoods;
	public static int lth = 0;//初始有四个物品
	
	public Goods(String name, double price, double bid, int totalAmount, int left) {
		
		Name = name;
		this.totalAmount = totalAmount;
		Price = price;
		this.left = left;
		this.bid = bid;
		
		lth ++;
	}

	public static int getLth() {
		return lth;
	}


	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getBid() {
		return bid;
	}

	public void reduceBid() {//reduce bid
		this.bid = 0.95 * bid;
	}

	public Goods(String name, int totalAmount, double price) {

		Name = name;
		this.totalAmount = totalAmount;
		Price = price;
		left = totalAmount;
		lth ++;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public String toString(){
		 String s = "Goods' name" + getName()+"\tPrice"+ getPrice() +"\tTotal Amount" + getTotalAmount() 
				+"\tLeft" + getLeft();
		 
		 return s;
	}
	
	public void addTotalNumOfGoods(int add){
		totalNumOfGoods += add;
	}
	
	public int getTotalNumOfGoods(){
		return totalNumOfGoods;
	}

	public double getAverageBid() {
		return averageBid;
	}

	public void setAverageBid(int num) {
		averageBid = ((totalAmount - num) * averageBid + num * bid )/(totalAmount);//更改bid后，用购买数量乘以进价，加上之前总价，除以总数量。
		
	}
	
	public void setAverageBid(double p) {
		averageBid = p;//更改bid后，用购买数量乘以进价，加上之前总价，除以总数量。
		System.out.print(averageBid);
	}

}
