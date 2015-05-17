package salesSystem;

import javax.swing.*;

public class DeleteGoods {
	String tmpname;
	Search search;

	public DeleteGoods() {
		search = new Search();
		tmpname = JOptionPane.showInputDialog(null, "Input product name",
				"Delete object", JOptionPane.PLAIN_MESSAGE);
		if (Search.isEmpty(tmpname))
			search.deleteGoods(tmpname);
	}

}
