package salesSystem;

import java.awt.*; 
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.net.URL;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends Frame implements ActionListener, ItemListener {
	TextField txId;
	TextField txPassWord;
	Label LbTitle;
	Label LbId;
	Label LbPassWord;
	Button btOK;
	Button btCancel;
	Button btReset;
	Label type;
	Choice typeChoice;
	Font myFont;
	String chtype;
	public User user;


	GUI() {
		super("Apple Shop");
		
		btOK = new Button("OK");
		btCancel = new Button("Exit");
		btReset = new Button("Reset");
		chtype = "seller";
		typeChoice = new Choice();
		type = new Label("Identity:");
		LbTitle = new Label("Apple Shop");
		LbTitle.setFont(myFont);
		LbId = new Label("User: ");
		txId = new TextField(10);
		LbPassWord = new Label("Password: ");
		txPassWord = new TextField(10);
		txPassWord.setEchoChar('*');
		myFont = new Font("Arial", Font.BOLD, 20);
		
		BufferedImage myPicture = new BufferedImage(1,1,1);
		try {
			 myPicture = ImageIO.read(new File("images.jpg"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		setLayout(gbl);
	
		
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		
		gbc.gridwidth = GridBagConstraints.CENTER;
		//	
		add(picLabel);

		gbc.gridx= 0;
		gbc.gridwidth = 1;
		add(LbId, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(txId, gbc);
		
		gbc.gridwidth = 1;
		add(LbPassWord, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(txPassWord, gbc);

		gbc.gridwidth = 1;
		add(type, gbc);
		add(typeChoice, gbc);

		typeChoice.add("seller");
		typeChoice.add("system manager");
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		add(typeChoice, gbc);

		gbc.anchor = GridBagConstraints.SOUTHWEST;
		gbc.gridwidth = 1;
		add(btOK, gbc);
		gbc.gridwidth = GridBagConstraints.BELOW_BASELINE;

		gbc.gridy =7;
		gbc.anchor = GridBagConstraints.SOUTH;
		add(btReset, gbc);
		gbc.gridwidth = GridBagConstraints.BELOW_BASELINE;
		
		gbc.gridy =7;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		add(btCancel, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		btOK.addActionListener(this);
		btReset.addActionListener(this);
		btCancel.addActionListener(this);
		typeChoice.addItemListener(this);

		setBackground(Color.white);
		setSize(300, 260);
		setBounds(450, 220, 260, 340);
		setVisible(true);
		validate();
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getItemSelectable() instanceof Choice) {
			chtype = ((Choice) e.getItemSelectable()).getSelectedItem();
		}
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btOK) {
			boolean a, b, c;

			a = Init.init.user1.userTypeJudge(txId.getText(),
					txPassWord.getText(), chtype);
			b = Init.init.user2.userTypeJudge(txId.getText(),
					txPassWord.getText(), chtype);
			c = Init.init.user3.userTypeJudge(txId.getText(),
					txPassWord.getText(), chtype);

			if (a || b || c) {
				if (chtype.equals("system manager")) {
					new ManagerGUI("system manager : Manger A");
					this.setVisible(false);
				} else {
					if (b)
						user = Init.init.user2;
					else
						user = Init.init.user3;

					new SalesmanGUI(txId.getText(), user);

					this.setVisible(false);
				}

			} else if (Init.init.user1.userPsdJudge(txId.getText(),
					txPassWord.getText())
					|| Init.init.user2.userPsdJudge(txId.getText(),
							txPassWord.getText())
					|| Init.init.user3.userPsdJudge(txId.getText(),
							txPassWord.getText()))
				JOptionPane.showMessageDialog(null, "Wrong password");
			else
				JOptionPane.showMessageDialog(null, "User not exist", "Error",
						JOptionPane.ERROR_MESSAGE);
		} else if (e.getSource() == btReset) {
			txId.setText("");
			txPassWord.setText("");
		} else if (e.getSource() == btCancel)
			System.exit(0);
	}
}
