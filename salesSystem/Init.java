package salesSystem;

public class Init {
	public User user1;
	public User user2;
	public User user3;
	public User user4;
	public User user5;
	public User user6;
	
	public Client client1;
	public Client client2;
	
	public Funds funds;
	
	public Client client[] = new Client[20];
	public Goods goods[] = new Goods[20];
	public static Init init = new Init();
	
	public Init(){
		try{
			user1 = new User("0001","0001","system manager"); 
			user2 = new User("0002","0002","seller"); 
			user3 = new User("0003","0003","seller");
			user4 = new User("0004","0004","seller");
			user5 = new User("0005","0005","seller");
			user6 = new User("0006","0006","seller");
			
			goods[0] = new Goods("iPad mini2", 2500.0,2500.0, 20, 20 );
			goods[1] = new Goods("iPad air", 3100.0, 3100.0, 20, 20 );
			goods[2] = new Goods("iphone5c", 2900.0, 2900.0, 20, 20 );
			goods[3] = new Goods("iphone5", 3500.0, 3500.0,20, 20 );
			goods[4] = new Goods("iphone5s", 4300.0, 4300.0, 20, 20 );
			
			client[0] = new Client("Ð¡ºì","female");
			client[1] = new Client("Ð¡ÂÌ","male");
			
			
			
			funds = new Funds(200000.0);
		}
		catch(UnexpectedCreate ee){System.out.println(ee.toString());
		}
		
		

	}
}
