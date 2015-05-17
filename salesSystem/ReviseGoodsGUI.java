package salesSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class ReviseGoodsGUI extends ReviseClientGUI {
	Search search;

	public ReviseGoodsGUI() {
		super("Revise Products");
		search = new Search();
		lbTitlel.setText("Revise product");
		lbID.setText("Product name");
		lbGender.setText("Price");
		lbGoodsname.setText("Left");
		lbGoodsprice.setVisible(false);
		lbGoodsamount.setVisible(false);
		txtGoodsprice.setVisible(false);
		txtGoodsamount.setVisible(false);
		btnOK.setBounds(30, 170, 80, 40);
		btnQuit.setBounds(110, 170, 80, 40);
		btnReset.setBounds(190, 170, 80, 40);
		setBounds(300, 160, 300, 270);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuit)
			dispose();
		else if (e.getSource() == btnOK) {
			String tmp = txtID.getText();
			int flag = 0;
			if (search.isEmpty(tmp)) {
				try {
					if (search.searchGoods(tmp) != null) {
						search.findGoods.setName(tmp);
						search.findGoods.setPrice(Integer.parseInt(txtGender
								.getText()));

						search.findGoods.setLeft(Integer.parseInt(txtGoodsname
								.getText()));
						JOptionPane.showMessageDialog(null,
								"Successfully revise product.");
					} else {
						JOptionPane.showMessageDialog(null,
								"The product is not existed.", "Warning",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (NumberFormatException ee) {
				}
			} else {
				txtID.setText("");
				txtGender.setText("");
				txtGoodsname.setText("");
			}
		}

	}
}
