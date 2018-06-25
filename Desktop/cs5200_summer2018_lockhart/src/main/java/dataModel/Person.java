package dataModel;

import java.sql.Date;

public abstract class Person {

	private int personId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Date dob;
	private String email;
	private String type;
//	private List<Address> addresses = new LinkedList<Address>();
//	private List<Phone> phones =  new LinkedList<Phone>();
	
	public Person(int personId, String firstName, String lastName, String username, String password, Date dob,
			String email, String type) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.email = email;
		this.type = type;
	}
	

	
	public Person() {
		// TODO Auto-generated constructor stub
		super();
	}

	
	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
//
//	public void addAddress(Address address) {
//		addresses.add(address); 
//	}
//	
//	public void removeAddress(Address address) {
//		addresses.remove(address);
//	}
//	public List<Address> getAddresses() {
//		return addresses;
//	}
//	
//	public void addPhone(Phone phone) {
//		phones.add(phone); 
//	}
//	
//	public void removePhone(Phone phone) {
//		phones.remove(phone);
//	}
//	public List<Phone> getPhones() {
//		return phones;
//	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public int getPersonId() {
		return personId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public java.util.Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}


	
}

