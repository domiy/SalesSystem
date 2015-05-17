package salesSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.io.*;

public class ChangeSalesmanPsd extends InquiryGoodsGUI {

	JLabel lbname;
	JLabel lbPWD;
	JLabel lbNewPWD;
	JLabel lbPWDAgain;

	JTextField txtname;
	JTextField txtPWD;
	JPasswordField JPNewPWD;
	JPasswordField txtPWDAgain;
	User u;

	public ChangeSalesmanPsd(User tmp){
		super();
		u = tmp;
		setTitle("Revise password");
		lbPWD=lbGender;
		lbNewPWD=lbGoodsname;
		lbPWDAgain=lbGoodsprice;
		txtPWD=txtGender;
		JPNewPWD=new JPasswordField();
		txtPWDAgain=new JPasswordField();
		lbTitlel.setText("Revise password");
		lbPWD. setText("Old password");
		lbNewPWD.setText("New password");
		lbPWDAgain.setText("epeated input ");
		add(JPNewPWD);
		add(txtPWDAgain);
		btnOK. setBounds (30, 210, 80, 40);
		btnQuit. setBounds (110, 210, 80, 40);
		btnReset. setBounds (190, 210, 80, 40);
		txtPWDAgain. setBounds (130, 170, 100, 30);
		JPNewPWD. setBounds (130, 130, 100, 30);
		lbID.setVisible(false);
		txtID.setVisible(false);
		txtGoodsname.setVisible(false);
		txtGoodsprice.setVisible(false);
		btnReset.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuit)
			dispose();
		if (e.getSource() == btnOK) {
			if (u.userPsdJudge(u.getPassWord(),txtPWD.getText())) {
				if (u.userPsdJudge(JPNewPWD.getText(), txtPWDAgain.getText())) {
					if (u.setPassWord(JPNewPWD.getText()))
						this.setVisible(false);
				} else
					JOptionPane.showMessageDialog(null,
							"password is not the same");
			} else
				JOptionPane.showMessageDialog(null, "The password is wrong",
						"Wrong", JOptionPane.ERROR_MESSAGE);
		}
		if (e.getSource() == btnReset) {
			txtPWD.setText("");
			JPNewPWD.setText("");
			txtPWDAgain.setText("");
		}

	}

}
