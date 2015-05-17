package salesSystem;

import javax.swing.*;
import java.awt.event.*;

public class ChangePsd extends ReviseClientGUI {
	JLabel lbTitle2;
	JLabel lbPWD;
	JLabel lbManagerPWD;
	JLabel lbPWDAgain;
	JLabel lbSalesmanID;
	JLabel lbSalesmanPWD;
	JTextField txtPWD;// ‘≠ º√‹¬Î
	JPasswordField txtManagerPWD;
	JPasswordField txtPWDAgain;
	JTextField txtSalesmanID;
	JPasswordField txtSalesmanPWD;

	public ChangePsd() {
		super("Revise password");
		lbPWD = lbID;
		lbManagerPWD = lbGender;
		lbPWDAgain = lbGoodsname;
		lbSalesmanID = lbGoodsprice;
		lbSalesmanPWD = lbGoodsamount;
		txtPWD = txtID;
		txtManagerPWD = new JPasswordField();
		txtPWDAgain = new JPasswordField();
		txtSalesmanPWD = new JPasswordField();
		txtSalesmanID = txtGoodsprice;
		lbPWD.setText("old password");
		lbTitlel.setText("Revise passwprd");
		lbTitle2 = new JLabel("Revise seller password");
		lbManagerPWD.setText("New password");
		lbPWDAgain.setText("Retype");
		lbSalesmanID.setText("seller ID");
		lbSalesmanPWD.setText("New password");

		lbTitle2.setBounds(60, 170, 200, 40);
		lbSalesmanID.setBounds(50, 210, 100, 30);
		txtSalesmanID.setBounds(130, 210, 100, 30);
		lbSalesmanPWD.setBounds(50, 250, 100, 30);
		txtManagerPWD.setBounds(130, 90, 100, 30);
		txtPWDAgain.setBounds(130, 130, 100, 30);
		txtSalesmanPWD.setBounds(130, 250, 100, 30);
		add(lbTitle2);
		add(txtManagerPWD);
		add(txtPWDAgain);
		add(txtSalesmanPWD);
		txtGender.setVisible(false);
		txtGoodsname.setVisible(false);
		txtGoodsamount.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuit) {
			dispose();
		}
		if (e.getSource() == btnOK) {
			if (txtSalesmanID.getText().equals("")) {
				if (judge(Init.init.user1.getPassWord(), txtPWD.getText())) {
					if (judge(txtManagerPWD.getText(), txtPWDAgain.getText())) {
						if (!txtManagerPWD.getText().equals("")) {
							if (Init.init.user1.setPassWord(txtManagerPWD
									.getText()))
								this.setVisible(false);
						} else
							JOptionPane.showMessageDialog(null,
									"Void password is illegal.");
					} else
						JOptionPane.showMessageDialog(null,
								"Not the same password");
				} else
					JOptionPane.showMessageDialog(null, "Wrong password");
			} else {
				if (judge(txtSalesmanID.getText(), Init.init.user2.getID())) {
					if (!txtSalesmanPWD.getText().equals("")) {
						if (Init.init.user2.setPassWord(txtSalesmanPWD
								.getText()))
							this.setVisible(false);
					} else
						JOptionPane.showMessageDialog(null,
								"Void password is illegal.");
				} else if (judge(txtSalesmanID.getText(),
						Init.init.user3.getID())) {
					if (!txtSalesmanPWD.getText().equals("")) {
						if (Init.init.user3.setPassWord(txtSalesmanPWD
								.getText()))
							this.setVisible(false);
					} else
						JOptionPane.showMessageDialog(null,
								"Void password is illegal.");
				} else
					JOptionPane.showMessageDialog(null,
							"The user name is not existed");
				if (e.getSource() == btnReset)
					txtPWD.setText("");
				txtManagerPWD.setText("");
				txtPWDAgain.setText("");
				txtSalesmanID.setText("");
				txtSalesmanPWD.setText("");
			}
		}
	}

	public boolean judge(String psd, String tmp) {
		if (psd.equals(tmp))
			return true;
		else
			return false;

	}
}
