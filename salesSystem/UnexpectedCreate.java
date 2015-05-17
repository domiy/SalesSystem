package salesSystem;

public class UnexpectedCreate extends Exception {
	private User user;
	private String IllegalPsd;

	public UnexpectedCreate(User user, String psd) {
		super("Illegal initial echarge money amount. ");
		this.user = user;
		IllegalPsd = psd;
	}

	public String toString() {
		String s;
		s = "Initial user error:" + user.getID() + "the password is illegal.";

		return s;
	}
}