package salesSystem;
import java.awt.*; 
import java.awt.event.*;

import javax.swing.*;
public class SalesmanInf extends JPanel implements ActionListener {
		Search search;
		JLabel SalesmanInf;
		public JLabel lbSellerID;
		public JLabel txtSellerID;
		public JLabel lbPartialSale;
		public JLabel txtPartialSale;
		public JLabel lbPartialProfit;
		public JLabel txtPartialProfit;
		public JButton btnOK;
		
		static String ID = "0002";
		double sales = 0.0;
		double profit = 0.0;

		JPanel resultPanel = new JPanel(new GridLayout(0, 1));
		
		public static void createAndShowGUI(String Id) {

			JFrame frame = new JFrame("Salesman Information");
			
			frame.setLocation(500, 300);

			JComponent newContentPane = new SalesmanInf();
			newContentPane.setOpaque(true);
			frame.setContentPane(newContentPane);

			frame.pack();
			frame.setVisible(true);
			ID = Id;	
		}
	public SalesmanInf(){
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

			
		JLabel patternLabel1 = new JLabel("Salesman Information");
		lbSellerID = new JLabel("Seller ID:", JLabel.LEADING);
		txtSellerID = new JLabel(" ");
		txtSellerID.setForeground(Color.black);
		txtSellerID.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.black),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		lbPartialSale = new JLabel("Sales:", JLabel.LEADING);
		txtPartialSale = new JLabel(" ");
		txtPartialSale.setForeground(Color.black);
		txtPartialSale.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.black),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)// 框框大小
				));
		
		lbPartialProfit = new JLabel("Total Profit", JLabel.LEADING);
		txtPartialProfit = new JLabel(" ");
		txtPartialProfit.setForeground(Color.black);
		txtPartialProfit.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.black),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)// 框框大小
				));
		btnOK = new JButton("OK");
		
		
		resultPanel.add(lbSellerID);
		resultPanel.add(txtSellerID);
		resultPanel.add(lbPartialSale);
		resultPanel.add(txtPartialSale);
		resultPanel.add(lbPartialProfit);
		resultPanel.add(txtPartialProfit);
        resultPanel.add(btnOK);
		btnOK.addActionListener(this);
		resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		add(resultPanel);

		resultPanel.setVisible(true);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		add(Box.createRigidArea(new Dimension(0, 100)));
	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnOK) {
		try{	
			txtSellerID.setText(ID + "");
			if(ID.equals("0002")){
				txtPartialSale.setText(Init.init.user2.getSales()+"");
				txtPartialProfit.setText(Init.init.user2.getProfit()+"");
			}else{
				txtPartialSale.setText(Init.init.user3.getSales()+"");
				txtPartialProfit.setText(Init.init.user3.getProfit()+"");
			}
			
		}catch (NumberFormatException ee) {
			JOptionPane.showMessageDialog(null,
					"Error", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	}
		
		
	
	
}
