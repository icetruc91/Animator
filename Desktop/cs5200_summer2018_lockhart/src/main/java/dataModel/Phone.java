package dataModel;

public class Phone {
	
	
	private int phoneId;
	private boolean primary;
	private String phoneNumber;
	
	public Phone(int phoneId, boolean primary, String phoneNumber) {
	super();
	this.phoneId = phoneId;
	this.primary = primary;
	this.phoneNumber = phoneNumber;
}
	
	public Phone() {
		super();
	}
	
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
