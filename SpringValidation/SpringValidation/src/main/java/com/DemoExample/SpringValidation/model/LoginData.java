package com.DemoExample.SpringValidation.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;


public class LoginData {
	
	@NotBlank(message="User Name can not be Empty!")
	@Size(min=3, max=20, message="User Name must be between 3-20 characters!!")
	private String username;
	
	@Email(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	
	@AssertTrue(message="Must Agree Terms & Condition!")
	private boolean agreed;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isAgreed() {
		return agreed;
	}
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
	
	
	@Override
	public String toString() {
		return "LoginData [username=" + username + ", email=" + email + "]";
	}
	
	
//	public LoginData(String username, String email) {
//		super();
//		this.username = username;
//		this.email = email;
//	}
	
	
	public LoginData() {
		// TODO Auto-generated constructor stub
	}


}

