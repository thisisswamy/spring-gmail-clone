package com.swamy.model;

import org.springframework.stereotype.Component;

@Component
public class UserModel {
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String confirmPassword;
	public UserModel(String firstName, String lastName, String emailId, String password, String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public UserModel() {
		super();
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPasswordString(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
