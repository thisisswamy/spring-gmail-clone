package com.swamy.model;

import org.springframework.stereotype.Component;

@Component
public class MailModel {
	
	private String mailFrom;
	private String mailTo;
	private String subject;
	private String mailBody;
	private String dateAndTime;
	public MailModel(String mailFrom, String mailTo, String subject, String mailBody, String dateAndTime) {
		super();
		this.mailFrom = mailFrom;
		this.mailTo = mailTo;
		this.subject = subject;
		this.mailBody = mailBody;
		this.dateAndTime = dateAndTime;
	}
	public MailModel() {
		super();
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
	

	@Override
	public String toString() {
		return "MailModel [mailFrom=" + mailFrom + ", mailTo=" + mailTo + ", subject=" + subject + ", mailBody="
				+ mailBody + ", dateAndTime=" + dateAndTime + "]";
	}
}
