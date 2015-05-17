package salesSystem;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class SalesmanGUI extends ManagerGUI {
	User u;
	String ID;

	public SalesmanGUI(String s, User tmp) {

		super(s);

		ID = s;
		u = tmp;
		radResetData.setText("1.Seller data");
		radAddData.setText("2.Add client data");
		radOrder.setText("3.Order processing");

		radCancelOrder.setText("4.Add product");
		radConsultProduct.setText("5.Find product");
		radResetPassWord.setText("6.Revise password");
		radResetData.setBounds(50, 50, 130, 40);
		radAddData.setBounds(50, 100, 130, 40);
		radOrder.setBounds(50, 150, 130, 40);
		radCancelOrder.setBounds(180, 50, 130, 40);
		radConsultProduct.setBounds(180, 100, 130, 40);
		radResetPassWord.setBounds(180, 150, 130, 40);
		btnQuit.setBounds(130, 200, 70, 40);
		lbltittle.setBounds(70, 10, 200, 40);
		radDeletData.removeActionListener(this);
		radPrintData.removeActionListener(this);
		radAddProduct.removeActionListener(this);
		radDeleteProduct.removeActionListener(this);
		radResetProduct.removeActionListener(this);
		lbltittle.setText("seller");
		radPrintData.setVisible(false);
		radDeletData.setVisible(false);
		radDeleteProduct.setVisible(false);
		radAddProduct.setVisible(false);
		radResetProduct.setVisible(false);
		setSize(350, 300);
		setBounds(300, 160, 350, 300);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("1.Seller data"))
			SalesmanInf.createAndShowGUI(ID);
		else if (e.getActionCommand().equals("2.Add client data"))
			new AddClientGUI();
		else if (e.getActionCommand().equals("3.Order processing"))
			new DeliverGUI();
		else if (e.getActionCommand().equals("4.Add product"))
			new AddGoods("Add product");
		else if (e.getActionCommand().equals("5.Find product"))
			new InquiryGoodsGUI();
		else if (e.getActionCommand().equals("6.Revise password")) {
			try {
				ChangeSalesmanPsd a = new ChangeSalesmanPsd(u);
			} catch (NullPointerException ee) {
			}
			if (e.getActionCommand()=="exist")
			  {
			
				dispose();
		
		      }
		}

	}
}
