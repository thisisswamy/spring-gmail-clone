package com.swamy.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swamy.entity.Inbox;
import com.swamy.entity.Sent;
import com.swamy.entity.Starred;
import com.swamy.entity.User;
import com.swamy.model.MailModel;
import com.swamy.repos.InboxRepo;
import com.swamy.repos.SentRepo;
import com.swamy.repos.StarredRepo;
import com.swamy.repos.UserRepo;
import com.swamy.services.MailService;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private SentRepo sentRepo;
	
	@Autowired
	private StarredRepo starredRepo;
	
	@Autowired
	private InboxRepo inboxRepo;

	
	public User getActiveUser(String emailId) {
		User user = userRepo.findByEmailId(emailId);
		return user;
	}
	public String getUniquStringValue() {
		 UUID randomValue = UUID.randomUUID();
		 return randomValue.toString();	
	}
	public void recievedMessage(Sent sent,User user, User sender) {
		Inbox inbox=new Inbox();
		inbox.setMailFrom(sent.getMailFrom());
		inbox.setMailTo(sent.getMailTo());
		inbox.setSubject(sent.getSubject());
		inbox.setMailBody(sent.getMailBody());
		inbox.setDateAndTime(sent.getDateAndTime());
		inbox.setUniqueMailId(getUniquStringValue());
		inbox.setUserName(sender.getFirstName()+" "+sender.getLastName());
		inbox.setUser(user);
		inboxRepo.save(inbox);
	}

	@SuppressWarnings("unused")
	@Override
	public void sendMessage(MailModel mailModel) throws Exception {
		User activeUser = getActiveUser(mailModel.getMailFrom());
		System.out.println("from : "+activeUser.getEmailId());
		User sender = getActiveUser(mailModel.getMailTo());
		System.out.println("To : "+sender.getEmailId());
		Sent sentMsg = new Sent();
		sentMsg.setMailFrom(mailModel.getMailFrom());
		sentMsg.setMailTo(mailModel.getMailTo());
		sentMsg.setSubject(mailModel.getSubject());
		sentMsg.setMailBody(mailModel.getMailBody());
		sentMsg.setDateAndTime(mailModel.getDateAndTime());
		sentMsg.setUniqueMailId(getUniquStringValue());
		sentMsg.setUserName(sender.getFirstName()+" "+sender.getLastName());
		sentMsg.setUser(activeUser);
		if(sender==null) {
			throw new Exception();
		}else {
			sentRepo.save(sentMsg);
			recievedMessage(sentMsg,sender,activeUser);
		}
	}
	@Override
	public List<Sent> getSentMessages(String emailId) {
		User activeUser = getActiveUser(emailId);
		return activeUser.getSents();
	}

	@Override
	public List<Inbox> getInboxMessages(String emailId) {
		User activeUser = getActiveUser(emailId);
		return activeUser.getInbox();
	}

	@Override
	public List<Starred> getStarredMessages(String emailId) {
		User activeUser = getActiveUser(emailId);
		return activeUser.getStarreds();
	}

	@Override
	public void deleteMail(String name,long id) {
		if(name.equals("sent")) {
			Sent mail = sentRepo.findById(id);
			mail.setUser(null);
			sentRepo.delete(mail);
		}
		else if (name.equals("inbox")) {
			Inbox mail = inboxRepo.findById(id);
			mail.setUser(null);
			inboxRepo.delete(mail);
		}

		else {
			Starred mail = starredRepo.findById(id);
			mail.setUser(null);
			starredRepo.delete(mail);
		}
		
	}

	@Override
	public void moveToStarredMsge(String folder ,long id) {
		if(folder.equals("sent")) {
			Sent mail = sentRepo.findById(id);
			Starred starred= new Starred(mail.getMailFrom(),mail.getMailTo(),mail.getMailBody(),mail.getSubject(),mail.getDateAndTime(),mail.getUniqueMailId(),mail.getUser());
			starredRepo.save(starred);
		}
		else if(folder.equals("inbox")) {
			Inbox mail = inboxRepo.findById(id);
			Starred starred= new Starred(mail.getMailFrom(),mail.getMailTo(),mail.getMailBody(),mail.getSubject(),mail.getDateAndTime(),mail.getUniqueMailId(),mail.getUser());
			starredRepo.save(starred);
		}
		else {
			Starred starred=starredRepo.findById(id);
			starred.setUser(null);
			starredRepo.delete(starred);
		}
		
	}


}
