package salesSystem;

import java.util.*; 
import javax.swing.JOptionPane;

public class Search {
	
	public int clientFlag;
	public int goodsFlag;
	public Client findClient;
	public Goods findGoods;

	public Search() {
		clientFlag = 0;
		goodsFlag = 0;
	}

	public Client searchClient(String name) {
		
		for (int i = 0; i < Client.lth; i++) {
			
			try {
				if (Init.init.client[i].getID().equals(name))
					findClient = Init.init.client[i];
			
				clientFlag = 1;
			} 
			
			catch (NullPointerException ee) {
			}
		}
		
		if(clientFlag == 0)
			findClient = null;
		
		return findClient;
		}
	

	public Goods searchGoods(String tmp){
		for (int i = 0; i < Goods.lth; i ++){
			
			try{
				
				if(Init.init.goods[i].getName().equals(tmp)){
					
					findGoods = Init.init.goods[i];
					goodsFlag = 1;
				}
			}
			catch(Exception ee){}
		}
		
		if (goodsFlag == 0)
			findGoods = null;
		
		return findGoods;
	}
	
	public boolean searchGoods2(String tmp){
		boolean b = false;
		for (int i = 0; i < Goods.lth; i ++){
			
			try{
				
				if(Init.init.goods[i].getName().equals(tmp)){
					
					findGoods = Init.init.goods[i];
					goodsFlag = 1;
				}
			}
			catch(Exception ee){}
		}
		
		if (goodsFlag == 1)
			b = true;
		
		return b;
	}
	
	
	public void deleteClient(String tmp){
		 int flag = 0;
		
		 for (int i = 0; i < Client.lth; i ++){
			 
			 if(Init.init.client[i].getID().equals(tmp)){
				 
				 int j;
				 
				 for(j = i; j < Client.lth; j ++){
					 Init.init.client[j] = Init.init.client[j + 1];
				 }
				 
				 Init.init.client[j] = null;
				 
				 Client.lth--;
				 
				 JOptionPane.showMessageDialog(null, "Client has been successfully deleted.");
				 
				 flag = 1;
				 
			 }
			 
			 if(flag == 0){
				 JOptionPane.showMessageDialog(null, "Client is not existed!","Warning", JOptionPane.WARNING_MESSAGE);
				 
				 JOptionPane.showInputDialog(null,"Input users name:","Delete Client",JOptionPane.PLAIN_MESSAGE);
			 }
		 }
	}
	
	public void deleteGoods(String tmp){
		 int flag = 0;
		
		 for (int i = 0; i < Goods.lth; i ++){
			 
			 if(Init.init.goods[i].getName().equals(tmp)){
				 
				 int j;
				 
				 for(j = i; j < Goods.lth; j ++){
					 Init.init.goods[j] = Init.init.goods[j + 1];
				 }
				 
				 Init.init.goods[j] = null;
				 
				 Goods.lth--;
				 
				 JOptionPane.showMessageDialog(null, "Goods have been successfully deleted.");
				 
				 flag = 1;
				 
			 }
			 
			 if(flag == 0){
				 JOptionPane.showMessageDialog(null, "Goods are not existed!","Warning", JOptionPane.WARNING_MESSAGE);
				 
				 JOptionPane.showInputDialog(null,"Input goods name:","Delete Goods",JOptionPane.PLAIN_MESSAGE);
			 }
		 }
	}
	
	public static boolean isEmpty(String tmp){
		try {
			if(tmp.length() == 0)
			{
				JOptionPane.showMessageDialog(null, "You didn't input any character!","ERROR",JOptionPane.ERROR_MESSAGE);
				
				return true;
			}
			else 
				return false;
		}
		catch (NullPointerException ee) {
		}
		return false;
	}
	
	public static double inquireFund(){
		return Init.init.funds.getMoney();
	}
	
	public static double inquireTotalSales(){
		return Init.init.funds.getTotalSales();
	}
	
	public static double inquireTotalProfit(){
		return Init.init.funds.getTotalProfit();
	}
}
