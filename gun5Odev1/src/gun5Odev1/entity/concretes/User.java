package gun5Odev1.entity.concretes;

import gun5Odev1.entity.abstracts.Entity;

public class User implements Entity{
	private String firsName;
	private String lastName;
	private String email;
	private String password;
	
	public User(String firsName, String lastName, String email, String password) {
		super();
		this.firsName = firsName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
