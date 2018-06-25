package dataModel;


import java.sql.Date;

public class User extends Person {
	
	private int userId;
	private boolean userAgreement;
	private String userKey;
	
	
	
	

	public User(int personId, String firstName, String lastName, String username, String password, Date dob,
			String email, String type, int userId, boolean userAgreement, String userKey) {
		super(personId, firstName, lastName, username, password, dob, email, type);
		this.userId = userId;
		this.userAgreement = userAgreement;
		this.userKey = userKey;
	}


	public User() {
		super();
	}
	
	
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isUserAgreement() {
		return userAgreement;
	}
	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}
	
	
}
