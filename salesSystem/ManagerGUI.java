package salesSystem;

import java.awt.*; 
import java.awt.event.*;

import javax.swing.*;


import javax.swing.JOptionPane;

public class ManagerGUI extends JFrame implements ActionListener {
	public Font myFont = new Font("Arial", Font.BOLD, 20);
	public JButton btnQuit = new JButton("exist");
	public JRadioButton radResetData;
	public JRadioButton radAddData;
	public JRadioButton radDeletData;
	public JRadioButton radPrintData;
	public JRadioButton radOrder;
	public JRadioButton radCancelOrder;
	public JRadioButton radConsultProduct;
	public JRadioButton radAddProduct;
	public JRadioButton radDeleteProduct;
	public JRadioButton radResetProduct;
	public JRadioButton radResetPassWord;
	public JRadioButton radFundsManagement;
	public JLabel lbltittle = new JLabel("system manager", JLabel.CENTER);
	public ButtonGroup radioGroup = new ButtonGroup();
	FrameListener fListener = new FrameListener();

	public ManagerGUI(String s) {
		super(s);

		radResetData = new JRadioButton("1.Revise client data", false);
		radAddData = new JRadioButton("2.Adde client data", false);
		radDeletData = new JRadioButton("3.Delete client data", false);
		radPrintData = new JRadioButton("4.Consult client data", false);
		radOrder = new JRadioButton("5.Order processing", false);
		radCancelOrder = new JRadioButton("6.Cancel order", false);
		radConsultProduct = new JRadioButton("7.Find product", false);
		radAddProduct = new JRadioButton("8.Add product", false);
		radDeleteProduct = new JRadioButton("9.Delete product", false);
		radResetProduct = new JRadioButton("10.Revise product", false);
		radResetPassWord = new JRadioButton("11.Revise password", false);
		radFundsManagement = new JRadioButton("12.Funds management", false);

		//GridBagLayout gbl = new GridBagLayout();
	
		Container c = getContentPane();
		c.setLayout(null);

		lbltittle.setFont(myFont);
		
		c.add(lbltittle);
		c.add(btnQuit);
		c.add(radResetData);
		c.add(radAddData);
		c.add(radDeletData);
		c.add(radPrintData);
		c.add(radOrder);
		c.add(radCancelOrder);
		c.add(radConsultProduct);
		c.add(radAddProduct);
		c.add(radDeleteProduct);
		c.add(radResetProduct);
		c.add(radResetPassWord);
		c.add(radFundsManagement);

		radioGroup.add(radResetData);
		radioGroup.add(radAddData);
		radioGroup.add(radDeletData);
		radioGroup.add(radPrintData);
		radioGroup.add(radOrder);
		radioGroup.add(radCancelOrder);
		radioGroup.add(radConsultProduct);
		radioGroup.add(radAddProduct);
		radioGroup.add(radDeleteProduct);
		radioGroup.add(radResetProduct);
		radioGroup.add(radResetPassWord);
		radioGroup.add(radFundsManagement);

		radResetData.addActionListener(this);
		radAddData.addActionListener(this);
		radDeletData.addActionListener(this);
		radPrintData.addActionListener(this);
		radOrder.addActionListener(this);
		radCancelOrder.addActionListener(this);
		radConsultProduct.addActionListener(this);
		radAddProduct.addActionListener(this);
		radDeleteProduct.addActionListener(this);
		radResetProduct.addActionListener(this);
		radResetPassWord.addActionListener(this);
		radFundsManagement.addActionListener(this);
		this.addWindowListener(fListener);

		
		radResetData.setBounds(50, 50, 200, 40);
		radAddData.setBounds(50, 100, 200, 40);
		radDeletData.setBounds(50, 150, 200, 40);
		radPrintData.setBounds(50, 200, 200, 40);
		radOrder.setBounds(50, 250, 200, 40);
		radCancelOrder.setBounds(50, 300, 200, 40);
		radConsultProduct.setBounds(300, 50, 200, 40);
		radAddProduct.setBounds(300, 100, 100, 40);
		radDeleteProduct.setBounds(300, 150, 200, 40);
		radResetProduct.setBounds(300, 200, 200, 40);
		radResetPassWord.setBounds(300, 250, 200, 40);
		radFundsManagement.setBounds(300, 300, 200, 40);
		lbltittle.setBounds(130, 10, 200, 40);
		btnQuit.setBounds(200, 350, 100, 40);
		btnQuit.addActionListener(this);
		setSize(500, 500);
		setVisible(true);
		setResizable(false);
		setBounds(300, 160, 500, 500);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("1.Revise client data")) {
			new ReviseClientGUI("Revise client data");
		} else if (e.getActionCommand().equals("2.Adde client data")) {
			new AddClientGUI();

		} else if (e.getActionCommand().equals("3.Delete client data")) {
			new DeleteClient();
		} else if (e.getActionCommand().equals("4.Consult client data")) {
			new InquiryClientGUI();
		} else if (e.getActionCommand().equals("5.Order processing")) {
			new DeliverGUI();
		} else if (e.getActionCommand().equals("6.Cancel order")) {
			JOptionPane.showMessageDialog(null, "Cancel");
		} else if (e.getActionCommand().equals("7.Find product")) {
			new InquiryGoodsGUI();
		} else if (e.getActionCommand().equals("8.Add product")) {
			new AddGoods("Add product");
		} else if (e.getActionCommand().equals("9.Delete product")) {
			new DeleteGoods();
		} else if (e.getActionCommand().equals("10.Revise product")) {
			new ReviseGoodsGUI();
		} else if (e.getActionCommand().equals("11.Revise password")) {
			new ChangePsd();
		}else if (e.getActionCommand().equals("12.Funds management")) {
			  FundsManagementGUI.createAndShowGUI();}
		 if (e.getSource() == btnQuit) {
					dispose();
				System.exit(0);

			}
		}
	
}