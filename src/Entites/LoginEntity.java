package Entites;

public class LoginEntity extends AbstractEntity {

	private String userName;
	private String Password;

	public LoginEntity() {

		userName = null;
		Password = null;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}