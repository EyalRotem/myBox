package Entites;

public class ForgotPassEntity extends AbstractEntity {
	/** user Name */
	private String userName;

	public ForgotPassEntity() {

		userName = null;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}