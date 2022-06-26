package com.swamy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="users_data_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String confirmPassword;
	@OneToMany(mappedBy = "user")
	private List<Inbox>inbox=new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Sent>sents=new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Starred>starreds=new ArrayList<>();
	
	
	public User(long id, String firstName, String lastName, String emailId, String password, String confirmPassword) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	
	
	public User(long id, String firstName, String lastName, String emailId, String password, String confirmPassword,
			List<Inbox> inbox, List<Sent> sents, List<Starred> starreds) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.inbox = inbox;
		this.sents = sents;
		this.starreds = starreds;
	}


	public User() {
		super();
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public List<Inbox> getInbox() {
		return inbox;
	}


	public void setInbox(List<Inbox> inbox) {
		this.inbox = inbox;
	}


	public List<Sent> getSents() {
		return sents;
	}


	public void setSents(List<Sent> sents) {
		this.sents = sents;
	}


	public List<Starred> getStarreds() {
		return starreds;
	}


	public void setStarreds(List<Starred> starreds) {
		this.starreds = starreds;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", inbox=" + inbox + ", sents="
				+ sents + ", starreds=" + starreds + "]";
	}

	
	
	

}
