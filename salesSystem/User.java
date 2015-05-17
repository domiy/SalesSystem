package salesSystem;
import javax.swing.*;
public class User {
	public static int lth;
	protected  String ID;
	private String PassWord;
	protected String UserType; 
	private double sales;
	private double profit;
	
	public double getSales() {
		return sales;
	}

	public void addSales(double add) {
		sales += add;
	}

	public double getProfit() {
		return profit;
	}

	public void addProfit(double add) {
		profit += add;
	}

	static{
		lth = 0;
	}
	
	public User(){}
	
	public User(String id){
		ID = id;
		PassWord = "098765";
		UserType = "seller";
		lth++;
	}
	
	public User(String id, String psd)throws UnexpectedCreate{
		this(id);
		if(psd.length() < 4)
			throw (new UnexpectedCreate(this, psd));
		PassWord = psd;
		
		UserType = "seller";
		lth++;
	}
	 
	public User(String id, String psd, String type) throws UnexpectedCreate{
		this(id, psd);
		UserType = type;
		lth++;
	}


	public  String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public String getPassWord(){
		return PassWord;
	}
	
	public boolean setPassWord(String password){
		if(password.length() == 0){
			JOptionPane.showMessageDialog(null, "You haven't input any character."
					,"Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (password.length() <= 6){
			JOptionPane.showMessageDialog(null,"Your password is too short."
					,"Warning",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else{
			PassWord = password;
			JOptionPane.showMessageDialog(null, "Successfully revise the password.");
			return true;
		}
	}
	
	public String getUserType(){
		 return UserType;
	}
	
	public void setUserType(String userType){
		UserType = userType;
	}
	
	public boolean userTypeJudge(String name, String pwd, String type){
		if(ID.equals(name)&&PassWord.equals(pwd)&&UserType.equals(type))
			return true;
		else
			return false;
	}
	
	public boolean userPsdJudge(String tmp, String pwd){
		if(tmp.equals(pwd))
			return true;
		else
			return false;
	}
	
	public String tostring(){
		String s;
		s = "User name:" + getID() + "PassWord:" + getPassWord() +
				"User type:" + getUserType();
		return s;
	}
}
