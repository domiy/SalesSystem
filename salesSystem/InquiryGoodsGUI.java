package salesSystem;

import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

public class InquiryGoodsGUI extends ReviseClientGUI {
	Search search;

	public InquiryGoodsGUI() {
		super("Find product");
		search = new Search();
		lbGoodsamount.setVisible(false);
		txtGoodsamount.setVisible(false);
		btnReset.setVisible(false);
		lbTitlel.setText("Find product");
		lbID.setText("Product name:");
		lbGender.setText("Price(RMB):");
		lbGoodsname.setText("Total amount:");
		lbGoodsprice.setText("Left:");
		btnReset.setVisible(false);
		btnQuit.setBounds(150, 220, 80, 40);
		btnOK.setBounds(50, 220, 80, 40);
		setSize(300, 320);
		setBounds(300, 160, 300, 320);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuit)
			dispose();
		else {
			String tmp = txtID.getText();
			if (!search.isEmpty(tmp)) {
				if (search.searchGoods(tmp) != null) {
					txtGoodsname.setText(String.valueOf(search.findGoods.getTotalAmount()));
					txtGoodsprice.setText(String.valueOf(search.findGoods.getLeft()));
					txtGender.setText(String.valueOf(search.findGoods.getPrice()));}
					                                            else JOptionPane.showMessageDialog(null,"Product not existed","Warning",JOptionPane.ERROR_MESSAGE);

				}

			}
		}
	
}
