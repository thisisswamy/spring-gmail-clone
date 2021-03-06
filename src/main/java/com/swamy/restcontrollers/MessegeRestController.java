package com.swamy.restcontrollers;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.entity.Inbox;
import com.swamy.entity.Sent;
import com.swamy.entity.Starred;
import com.swamy.model.MailModel;
import com.swamy.services.MailService;

@RestController
@RequestMapping("api/messeges/")
@CrossOrigin(origins = "https://partial-gmail-clone-app.herokuapp.com/")
public class MessegeRestController {
	@Autowired
	private MailService mailService;
	
	@PostMapping("/send")
	public void sendMessage(@RequestBody MailModel mailModel) throws Exception {
		mailService.sendMessage(mailModel);
	}
	
	@GetMapping("/sent/{emailId}")
	public List<Sent> getSentMessages(@PathVariable String emailId){
		return mailService.getSentMessages(emailId);
	}
	
	@GetMapping("/inbox/{emailId}")
	public List<Inbox> getInboxMessages(@PathVariable String emailId){
		return mailService.getInboxMessages(emailId);
	}
	
	@GetMapping("/starred/{emailId}")
	public List<Starred> getStarredMessages(@PathVariable String emailId){
		return mailService.getStarredMessages(emailId);
	}
	
	@DeleteMapping("/delete/{name}/{id}")
	public void deleteMail(@PathVariable String name, @PathVariable long id) {
		mailService.deleteMail(name,id);
	}
	@PutMapping("/starred/{folder}/{id}")
	public void moveToStarredMsge(@PathVariable String folder,@PathVariable long id) {
		mailService.moveToStarredMsge(folder ,id);
	}
	
	@ExceptionHandler(value=UserPrincipalNotFoundException.class)
	public String exceptionHandler() {
		return "User not found Please check sender mail again ! Thank You";
	}
	
	@ExceptionHandler(value=SQLException.class)
	public String sqlExceptionHandler() {
		return "Data too long please limit the data";
	}


}
