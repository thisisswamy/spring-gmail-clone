package com.swamy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swamy.entity.Inbox;
import com.swamy.entity.Sent;
import com.swamy.entity.Starred;
import com.swamy.entity.User;
import com.swamy.model.MailModel;

@Service
public interface MailService {
	
	User sendMessage(MailModel mailModel) throws Exception;
	List<Sent> getSentMessages(String emailId);
	List<Inbox> getInboxMessages(String emailId);
	List<Starred> getStarredMessages(String emailId);
	MailModel deleteMail(long id);
	void moveToStarredMsge(long id);
}
