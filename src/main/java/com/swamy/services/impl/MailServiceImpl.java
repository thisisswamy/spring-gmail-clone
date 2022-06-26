package com.swamy.services.impl;

import java.util.List;

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
	public void recievedMessage(Sent sent,User user) {
		Inbox inbox=new Inbox(sent.getMailFrom(),sent.getMailTo(),sent.getMailBody(),sent.getSubject(),sent.getDateAndTime(),user);
		inboxRepo.save(inbox);
	}

	@Override
	public User sendMessage(MailModel mailModel) throws Exception {
		User activeUser = getActiveUser(mailModel.getMailFrom());
		User sender = getActiveUser(mailModel.getMailTo());
		Sent sentMsg = new Sent();
		sentMsg.setMailFrom(mailModel.getMailFrom());
		sentMsg.setMailTo(mailModel.getMailTo());
		sentMsg.setSubject(mailModel.getSubject());
		sentMsg.setMailBody(mailModel.getMailBody());
		sentMsg.setDateAndTime(mailModel.getDateAndTime());
		sentMsg.setUser(activeUser);
		
		if(sender==null) {
			throw new Exception();
		}else {
			sentRepo.save(sentMsg);
			recievedMessage(sentMsg,sender);
		}
		return activeUser;
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
	public MailModel deleteMail(long id) {
		Sent mail = sentRepo.findById(id);
		mail.setUser(null);
		MailModel mailModel=new MailModel(mail.getMailFrom(),mail.getMailTo(),mail.getSubject(),mail.getMailBody(),mail.getDateAndTime());
		sentRepo.delete(mail);
		return mailModel;
	}

	@Override
	public void moveToStarredMsge(long id) {
		Sent mail = sentRepo.findById(id);
		Starred starred=new Starred(mail.getMailFrom(),mail.getMailTo(),mail.getSubject(),mail.getMailBody(),mail.getDateAndTime(),mail.getUser());
		starredRepo.save(starred);
	}


}
