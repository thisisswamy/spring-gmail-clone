package com.swamy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sent_box_table")
public class Sent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String mailFrom;
	private String mailTo;
	private String subject;
	private String mailBody;
	private String dateAndTime;
	private String uniqueMailId;
	private String userName;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id",referencedColumnName = "id",updatable = true)
	private User user;
	public Sent(String mailFrom, String mailTo, String subject, String mailBody, String dateAndTime,
			String uniqueMailId, User user) {
		super();
		this.mailFrom = mailFrom;
		this.mailTo = mailTo;
		this.subject = subject;
		this.mailBody = mailBody;
		this.dateAndTime = dateAndTime;
		this.uniqueMailId = uniqueMailId;
		this.user = user;
		this.userName= user.getFirstName()+" " + user.getLastName();
	}
	public Sent() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMailFrom() {
		return mailFrom;
	}
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMailBody() {
		return mailBody;
	}
	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public String getUniqueMailId() {
		return uniqueMailId;
	}
	public void setUniqueMailId(String uniqueMailId) {
		this.uniqueMailId = uniqueMailId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
}
