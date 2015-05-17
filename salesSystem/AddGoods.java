package salesSystem;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class AddGoods extends ReviseClientGUI {
	public JTextField txtGoodsnamel;
	public JTextField txtGoodspricel;
	public JTextField txtGoodsBid;
	public JTextField txtGoodsamountl;

	public JLabel lbGoodsnamel;
	public JLabel lbGoodsBid;
	public JLabel lbGoodspricel;
	public JLabel lbGoodsamountl;
	
	Search sGoods;

	public AddGoods(String s) {
		super(s);
		sGoods = new Search();
		txtGoodsnamel = txtID;
		txtGoodspricel = txtGender;
		txtGoodsBid = txtGoodsname;
		txtGoodsamountl = txtGoodsprice;

		lbGoodsnamel = lbID;
		lbGoodspricel = lbGender;
		lbGoodsBid = lbGoodsname;
		lbGoodsamountl = lbGoodsprice;

		lbTitlel.setText("Add product");

		lbGoodsnamel.setText("Product name:");
		lbGoodspricel.setText("product price:");
		lbGoodsBid.setText("Bid:");
		lbGoodsamountl.setText("Total Amount:");

		btnOK.setBounds(30, 205, 80, 40);
		btnQuit.setBounds(110, 205, 80, 40);
		btnReset.setBounds(190, 205, 80, 40);

		setSize(300, 270);
		setBounds(300, 200, 300, 270);

		lbGoodsamount.setVisible(false);
		txtGoodsamount.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuit)
			dispose();
		else if (e.getSource() == btnOK) {
			String tmpname = txtGoodsnamel.getText();
			if (!sGoods.isEmpty(tmpname)) {
				try {
					boolean b = sGoods.searchGoods2(tmpname);
					if (b) {// ������Ʒ����=��һ�ν��۶��*0.95��
						try {
							
							Goods GoodsID = sGoods.searchGoods(tmpname);// �ҵ�ͬ����Goods
								GoodsID.setTotalAmount(GoodsID.getTotalAmount()
									+ Integer.parseInt(txtGoodsamountl
											.getText()));// ������Ʒ����
								GoodsID.setBid(Double.parseDouble(txtGoodsBid.getText()));
								
								GoodsID.setAverageBid(Integer.parseInt(txtGoodsamountl
											.getText()));// ������ι������ƽ������
								
							Init.init.funds.expense(GoodsID.getBid() * Integer.parseInt(txtGoodsamountl
									.getText()));// ���ʽ����ȥ����

							GoodsID.setLeft(GoodsID.getLeft()
									+ Integer.parseInt(txtGoodsamountl
											.getText()));// ʣ��������
							JOptionPane.showMessageDialog(null,
									"Successfully added");
						} catch (NumberFormatException ee) {
							JOptionPane.showMessageDialog(null,
									"Please enter number", "Error",
									JOptionPane.WARNING_MESSAGE);
						}

					} else {
						try { 
							
							Init.init.goods[Goods.lth] = new Goods(
									tmpname,
									Double.parseDouble(txtGoodspricel.getText()),
									Double.parseDouble(txtGoodsBid.getText()),
									Integer.parseInt(txtGoodsamountl.getText()),
									Integer.parseInt(txtGoodsamountl.getText()));
							int j = Goods.lth - 1;
							Init.init.goods[j].setAverageBid(Double.parseDouble(txtGoodsBid.getText()));// ������ι������ƽ������
							
							Init.init.funds.expense(Double
									.parseDouble(txtGoodsBid.getText()) * Integer.parseInt(txtGoodsamountl
											.getText()));

							JOptionPane.showMessageDialog(null,
									"Successfully added");
							this.setVisible(true);
						} catch (NumberFormatException ee) {
							JOptionPane.showMessageDialog(null,
									"Please enter number", "Error",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				}

				catch (NullPointerException eee) {
				}
			}
		} else {
			txtGoodsnamel.setText("");
			txtGoodsBid.setText("");
			txtGoodspricel.setText("");
			txtGoodsamountl.setText("");
		}

	}
}
