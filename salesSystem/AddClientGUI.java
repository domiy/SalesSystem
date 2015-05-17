package salesSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddClientGUI extends AddGoods {
	Search search = new Search();

	public AddClientGUI() {
		super("Add Client");
		lbID.setText("Client's name");
		lbGender.setText("Gender");
		lbTitlel.setText("Add Client");
		lbGoodsamountl.setVisible(false);
		txtGoodsamountl.setVisible(false);
		btnOK.setBounds(30, 130, 80, 40);
		btnQuit.setBounds(110, 130, 80, 40);
		btnReset.setBounds(190, 130, 80, 40);
		setSize(300, 230);
		setBounds(300, 160, 300, 230);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuit)
			dispose();
		else if (e.getSource() == btnOK) {
			String tmpname = txtGoodsnamel.getText();
			if (!Search.isEmpty(tmpname)) {
				try {
					//search.searchClient(tmpname);
					if (search.findClient != null)
						JOptionPane.showMessageDialog(null,
								"This client has existed");
					else {
						Init.init.client[Client.lth++] = new Client(tmpname,
								txtGoodspricel.getText());
						JOptionPane.showMessageDialog(null,
								"Successful add client");
						this.setVisible(false);
					}
				} catch (NullPointerException ee) {
				}

			} else {
				txtID.setText("");
				txtGender.setText("");
			}
		}
	}
}
