package fi.digiprojekti.yummy.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterNewUser {
	
	@NotEmpty
	@Size(min=3, max=30)
	private String username = "";
	
	@NotEmpty
	@Size(min=3, max=30)
	private String firstname = "";
	
	@NotEmpty
	@Size(min=3, max=30)
	private String lastname = "";
	
	@NotEmpty
	@Size(min=4, max=30)
	private String password = "";
	
	@NotEmpty
	@Size(min=4, max=30)
	private String passwordCheck = "";
	
	@NotEmpty
	private String role = "";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
