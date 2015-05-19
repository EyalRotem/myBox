package Entites;

public class User extends AbstractEntity {

	private String UserName;
	private String FirstName;
	private String LastName;
	private String Password;
	private int Privilege;
	private int Status;

	public User(String UserName){
		this.UserName = UserName;
	}
	
	public User(String UserName,String Password, String FirstName, String LastName, int Status,int Privilege) {
		this.UserName = UserName;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Password = Password;
		this.Status = Status;
		this.Privilege = Privilege;
	}

	public String getTask() {
		return null;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getUserName() {
		return UserName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getPassword() {
		return Password;
	}

	public int getStatus() {
		return Status;
	}

	public int getPrivilege() {
		return Privilege;
	}

}
