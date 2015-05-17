package salesSystem;

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class FundsManagementGUI extends JPanel implements ActionListener {

	JLabel FundsManagement;
	Search search;
	public JButton btnOK;
	public JLabel lbFunds;
	public JLabel txtFunds;
	public JLabel lbTotalSale;
	public JLabel txtTotalSale;
	public JLabel lbAverageBid;
	public JLabel txtAverageBid;
	public JLabel lbName;
	public JLabel lbTotalProfit;
	public JLabel txtTotalProfit;
	public JTextField txtName;

	JPanel Panel = new JPanel(new GridLayout(0, 1));
	JPanel resultPanel = new JPanel(new GridLayout(0, 1));
	JPanel averagePanel = new JPanel(new GridLayout(0, 1));

	public static void createAndShowGUI() {

		JFrame frame = new JFrame("FundsManagementGUI");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(500, 300);

		JComponent newContentPane = new FundsManagementGUI();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setVisible(true);
	}

	public FundsManagementGUI() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JLabel patternLabel1 = new JLabel("Funds Management");
		lbFunds = new JLabel("Funds:", JLabel.LEADING);
		txtFunds = new JLabel(" ");
		txtFunds.setForeground(Color.black);
		txtFunds.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.black),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		lbTotalSale = new JLabel("Total Sales", JLabel.LEADING);
		txtTotalSale = new JLabel(" ");
		txtTotalSale.setForeground(Color.black);
		txtTotalSale.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.black),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)// 框框大小
				));
		
		lbTotalProfit = new JLabel("Total Profit", JLabel.LEADING);
		txtTotalProfit = new JLabel(" ");
		txtTotalProfit.setForeground(Color.black);
		txtTotalProfit.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.black),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)// 框框大小
				));

		Panel.setLayout(new BoxLayout(Panel, BoxLayout.PAGE_AXIS));

		String[] ConsultStrings = { "Inquire fund", "Average bid" };// set up
																	// list
		JComboBox List = new JComboBox(ConsultStrings);
		List.setSelectedIndex(1);
		List.addActionListener(this);

		Panel.add(patternLabel1);
		List.setAlignmentX(Component.LEFT_ALIGNMENT);
		Panel.add(List);

		resultPanel.add(lbFunds);
		resultPanel.add(txtFunds);
		resultPanel.add(lbTotalSale);
		resultPanel.add(txtTotalSale);
		resultPanel.add(lbTotalProfit);
		resultPanel.add(txtTotalProfit);

		Panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		add(Panel);
		add(Box.createRigidArea(new Dimension(0, 0)));
		add(resultPanel);
		add(Box.createRigidArea(new Dimension(0, 10)));

		resultPanel.setVisible(false);
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		lbAverageBid = new JLabel("Average Bid:", JLabel.LEADING);// 设置另一个界面
		txtAverageBid = new JLabel(" ");
		lbName = new JLabel("Goods name:", JLabel.LEADING);
		txtName = new JTextField("");
		btnOK = new JButton("OK");
		txtAverageBid.setForeground(Color.black);
		txtAverageBid.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.black),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		averagePanel.add(lbAverageBid);
		averagePanel.add(txtAverageBid);
		averagePanel.add(lbName);
		averagePanel.add(txtName);
		averagePanel.add(btnOK);
		btnOK.addActionListener(this);
	

		averagePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

		add(Panel);
		add(averagePanel);
		add(Box.createRigidArea(new Dimension(0, 150)));

		averagePanel.setVisible(false);
		// setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

	}

	public void actionPerformed(ActionEvent e) {
		Search sGoods = new Search();
		
		if (e.getSource()==btnOK) {
		try{			
			Goods GoodsID = sGoods.searchGoods(txtName.getText());
			txtAverageBid.setText(""+GoodsID.getAverageBid());
		}catch (NumberFormatException ee) {
			JOptionPane.showMessageDialog(null,
					"item nor existed", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
	}
		else {JComboBox fund = (JComboBox) e.getSource();
		
		String type = (String) fund.getSelectedItem();
		

		search = new Search();

		if (type == "Inquire fund") {
			String funds;
			String totalSales;
			String totalProfit;
			
			funds = "" + search.inquireFund();
			txtFunds.setText(funds);
			
			totalSales = "" + search.inquireTotalSales();
			txtTotalSale.setText(totalSales);
			
			totalProfit = "" + search.inquireTotalProfit();
			txtTotalProfit.setText(totalProfit);
			
			resultPanel.setVisible(true);
			averagePanel.setVisible(false);
		}

		if (type == "Average bid") {

			resultPanel.setVisible(false);
			averagePanel.setVisible(true);

		}
		
		}
	
	}
}
