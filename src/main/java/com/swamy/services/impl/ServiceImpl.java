package com.swamy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swamy.entity.User;
import com.swamy.model.UserModel;
import com.swamy.repos.SentRepo;
import com.swamy.repos.UserRepo;
import com.swamy.services.Service;

@Component
public class ServiceImpl implements Service {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private SentRepo sentRepo;
	@Override
	public User registerUser(UserModel userModel) {
		User user=new User();
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setEmailId(userModel.getEmailId());
		user.setPassword(userModel.getPassword());
		user.setConfirmPassword(userModel.getConfirmPassword());
		User savedUser = userRepo.save(user);
		return savedUser;
	}
	@Override
	public List<User> getusers() {
		List<User> usersList = userRepo.findAll();
		return usersList;
	}
	

}
