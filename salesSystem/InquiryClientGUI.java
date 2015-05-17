package salesSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InquiryClientGUI extends ReviseClientGUI {
	Search search;

	public InquiryClientGUI(){
		super("Find client");
		search = new Search();
		lbTitlel.setText("Find client data");
		lbID.setText("Input client ID");
		txtGender.setVisible(false);
		lbGender.setText("");
		lbGoodsname.setText("");
		txtGoodsname.setVisible(false);
		lbGoodsprice.setText("");
		txtGoodsprice. setVisible(false);
		txtGoodsprice. setVisible(false);
		lbGoodsamount.setVisible(false);
		txtGoodsamount.setVisible(false);
		btnReset. setVisible(false);
		lbGender. setBounds (50, 100, 100, 200);
		lbGoodsname. setBounds (50, 150, 300, 30);
		lbGoodsprice. setBounds (50, 200, 300, 30);
		btnQuit. setBounds (280, 300, 80, 40);
		btnOK. setBounds (150, 300, 80, 40);
		setSize(500,390);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnQuit)
			dispose();
		else {
			String goodsifo;
			String amountifo;
			String tmpname = txtID.getText().trim();
			//System.out.print(txtID.getText().trim());
			if (search.searchClient(tmpname) != null) {
				goodsifo = search.findClient.printGoods();
				amountifo=search.findClient.printAmount();
						lbGender.setText("gender:"+search.findClient.getGender());
						    lbGoodsname.setText(goodsifo);
						    lbGoodsprice.setText(amountifo);}
						else lbGoodsname.setText("Customer not existed.");}
						       
			

	}
}
