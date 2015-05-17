package salesSystem;

import javax.swing.*;

public class DeleteClient {
	String tmpname;
	Search search;

	public DeleteClient() {
		search = new Search();
		tmpname = JOptionPane.showInputDialog(null, "Input client name",
				"Delete client", JOptionPane.PLAIN_MESSAGE);
		if (Search.isEmpty(tmpname))
			search.deleteClient(tmpname);
	}

}
