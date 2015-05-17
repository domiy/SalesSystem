package salesSystem;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class DeliverGUI extends ReviseClientGUI {
	Search search = new Search();
	JLabel lbClientName;
	/*
	 * JLabel lbClientAddress; JLabel lbClientTelephone;
	 */
	JTextField txtClientName;

	/*
	 * JTextField txtClientAddress; JTextField txtClientTelephone;
	 */
	public DeliverGUI() {
		super("Order");

		lbTitlel.setText("Order");
		lbID.setText("Product name");
		lbGender.setText("Product amount");
		lbGoodsname.setText("Price:");
		lbGoodsprice.setText("Seller ID");// 销售人员id

		lbGoodsamount.setText("Client name:");// 客户姓名
		lbAddress.setText("Client Address:");
		lbTele.setText("Client Telephone");

		lbAddress.setVisible(true);
		txtAddress.setVisible(true);
		lbTele.setVisible(true);
		txtTele.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuit)
			dispose();
		else if (e.getSource() == btnOK) {
			Search sGoods = new Search();

			String productname = txtID.getText();
			String price = txtGoodsname.getText();
			String productAmount = txtGender.getText();
			String sellerID = txtGoodsprice.getText();
			String clientName = txtGoodsamount.getText();
			String address = txtAddress.getText();
			String tele = txtTele.getText();
			int confirm = 0;

			Goods GoodsID = sGoods.searchGoods(productname);
		
			if ((Double.parseDouble(price) - GoodsID.getBid())
					/ GoodsID.getBid() <= 0.15) {
				JOptionPane.showMessageDialog(null,
						"The profit is less than 15%");

				confirm = JOptionPane.showConfirmDialog(null, "Confirm?");

			}

			if (confirm == 0) {
				JOptionPane.showMessageDialog(null, "Product Name: "
						+ productname + "\n" + "Price: " + price + "\n"
						+ "Amount: " + productAmount + "\n" + "Seller ID: "
						+ sellerID + "\n" + "Client name: " + clientName + "\n"
						+ "Address: " + address + "\n" + "Telephone: " + tele
						+ "\n");
				try {
					double price2 = Double.parseDouble(price);
					int amount = Integer.parseInt(productAmount);
					
						Goods goods = search.searchGoods(productname);
						Init.init.funds.addTotalProfit((price2 - goods.getAverageBid())*amount);
						  Init.init.funds.addTotalSales(price2 * amount);
						  Init.init.funds.addFunds(price2 * amount);
				    
						goods.setLeft(goods.getLeft() - amount );
						Client client = search.searchClient(clientName);
						client.buyGoods(productname,Double.parseDouble(price),Integer.parseInt(productAmount) );
						
						if(sellerID.equals("0002")){
							Init.init.user2.addProfit((price2 - goods.getBid())*amount);
							Init.init.user2.addSales(price2 * amount);
						}else{
							Init.init.user3.addProfit((price2 - goods.getBid())*amount);
							Init.init.user3.addSales(price2 * amount);
						}
							
				}

				catch (NumberFormatException ee) {
					JOptionPane.showMessageDialog(null, "Invalid input",
							"Warning", JOptionPane.WARNING_MESSAGE);
				}
			}

		} else {
			txtID.setText("");
			txtGoodsname.setText("");
			txtGoodsamount.setText("");
			txtGender.setText("");
			txtGoodsprice.setText("");// 销售人员id
			txtAddress.setText("");
			txtTele.setText("");
		}
	}
}
