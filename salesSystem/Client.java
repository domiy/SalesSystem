package salesSystem;

public class Client extends User{
	private String Gender;
	public String Goods[] = new String[15];
	public double Price[] = new double[15];
	public int Amount[] = new int[15];
	private int goodslth;
	
	
	static {
		lth = 0;
	}
	
	public Client (String id){
		super(id);
		ID = id;
		Gender = "female";
		UserType = "Client";
		lth ++;
		goodslth = 0;
		
	}
	
	public Client(String id, String sex){
		super();
		ID = id;
		Gender = sex;
		UserType = "Client";
		lth ++;
		goodslth = 0;
		
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}


	public int getGoodslth() {
		return goodslth;
	}

	public void setGoodslth(int goodslth) {
		this.goodslth = goodslth;
	}
	
	public void buyGoods(String goods, double price, int amount){
		Goods[goodslth] = goods;
		Price[goodslth] = price;
		Amount[goodslth] = amount;
		goodslth++;
	}
	
	public String printGoods(){
		String tmp = "Goods :";
		
		for(int i = 0; i < getGoodslth(); i++){
			tmp += Goods[i] + ",";
		}
		
		return tmp;
	}
	
	public String printAmount(){
		String tmp = "Amount£º";
		
		for(int i = 0; i < getGoodslth(); i++){
			tmp += Amount[i] + ",";
		}
		return tmp;
	}
	
	public  String getID() {
		return ID;
	}
}
