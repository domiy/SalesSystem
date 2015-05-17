package salesSystem;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class ReviseClientGUI extends JFrame implements ActionListener {
	public JButton btnOK;
	public JButton btnQuit;
	public JButton btnReset;
	public Font myFont;
	public JLabel lbTitlel;
	public JLabel lbID;
	public JLabel lbGender;
	public JLabel lbGoodsname;
	public JLabel lbGoodsprice;
	public JLabel lbGoodsamount;
	public JLabel lbAddress;
	public JLabel lbTele;
	public JTextField txtID;
	public JTextField txtGender;
	public JTextField txtGoodsname;
	public JTextField txtGoodsprice;
	public JTextField txtGoodsamount;
	public JTextField txtAddress;
	public JTextField txtTele;

	public ReviseClientGUI(String s) {
		super(s);
		btnOK = new JButton("OK");
		btnQuit = new JButton("Exist");
		btnReset = new JButton("Reset");
		myFont = new Font("Arial", Font.BOLD, 20);
		lbTitlel = new JLabel("Revise client data");
		lbID = new JLabel("User Id");
		lbGender = new JLabel("Gender");
		lbGoodsname = new JLabel("Product name");
		lbGoodsprice = new JLabel("Price");
		lbGoodsamount = new JLabel("Amount");
		lbAddress = new JLabel("Client address:");
		lbTele = new JLabel("Client Telephone:");
		txtID = new JTextField();
		txtGender = new JTextField();
		txtGoodsname = new JTextField();
		txtGoodsprice = new JTextField();
		txtGoodsamount = new JTextField();
		txtAddress = new JTextField();
		txtTele = new JTextField();
		setLayout(null);
		lbTitlel.setFont(myFont);

		btnOK.setBounds(30, 360, 80, 40);
		btnQuit.setBounds(110, 360, 80, 40);
		btnReset.setBounds(190, 360, 80, 40);
		lbTitlel.setBounds(100, 0, 150, 40);
		lbID.setBounds(40, 50, 100, 30);
		txtID.setBounds(130, 50, 100, 30);
		lbGender.setBounds(40, 90, 100, 30);
		txtGender.setBounds(130, 90, 100, 30);
		lbGoodsname.setBounds(40, 130, 100, 30);
		txtGoodsname.setBounds(130, 130, 100, 30);
		lbGoodsprice.setBounds(40, 170, 100, 30);
		txtGoodsprice.setBounds(130, 170, 100, 30);
		lbGoodsamount.setBounds(40, 210, 100, 30);
		txtGoodsamount.setBounds(130, 210, 100, 30);
		lbAddress.setBounds(40, 250, 100, 30);
		txtAddress.setBounds(130, 250,100,30);
		lbTele.setBounds(40, 290, 120, 30);
		txtTele.setBounds(130, 290,100,30);
		add(lbTitlel);
		add(btnOK);
		add(btnQuit);
		add(btnReset);
		add(lbID);
		add(lbGender);
		add(lbGoodsname);
		add(lbGoodsprice);
		add(lbGoodsamount);
		add(txtID);
		add(txtGender);
		add(txtGoodsname);
		add(txtGoodsprice);
		add(txtGoodsamount);
		
		add(lbAddress);
		add(lbTele);
		add(txtAddress);
		add(txtTele);
		
		btnOK.addActionListener(this);
		btnQuit.addActionListener(this);
		btnReset.addActionListener(this);
		setSize(300, 460);
		setBounds(450, 220, 300, 460);
		setVisible(true);
		setResizable(false);
		lbAddress.setVisible(false);
		txtAddress.setVisible(false);
		lbTele.setVisible(false);
		txtTele.setVisible(false);
		validate();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuit)
			dispose();

		if (e.getSource() == btnOK) {
			int flagman = 0;
			int flaggoods = 0;
			int success = 0;

			for (int i = 0; i < Client.lth; i++) {
				if (Init.init.client[i].getID().equals(txtID.getText())) {
					success = 1;
					flagman = 1;
					if (!txtID.getText().equals(""))
						Init.init.client[i].setID(txtID.getText());
					if (!txtGender.getText().equals(""))
						Init.init.client[i].setGender(txtGender.getText());
					for (int j = 0; j < Init.init.client[i].getGoodslth(); j++) {
						if (Init.init.client[i].Goods[j].equals(txtGoodsname
								.getText())) {
							flaggoods = 1;
							int tmp = Integer.parseInt(txtGoodsamount.getText()
									.trim());
							Init.init.client[i].Amount[j] = tmp;

						}

					}
					if (flaggoods == 0) {
						JOptionPane.showMessageDialog(null,
								"Client hasn't bought this item.", "Error",
								JOptionPane.ERROR_MESSAGE);
						success = 0;
					}

				}

			}
			if (success == 1)
				JOptionPane.showMessageDialog(null,
						"Successfully revise client data");
			if (flagman == 0 & success == 0)
				JOptionPane.showMessageDialog(null, "Client not existed.",
						"Error", JOptionPane.WARNING_MESSAGE);
		}
		if (e.getSource() == btnReset) {
			txtID.setText("");
			txtGender.setText("");
			txtGoodsname.setText("");
			txtGoodsprice.setText("");
			txtGoodsamount.setText("");

		}
	}

}
