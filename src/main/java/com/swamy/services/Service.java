package com.swamy.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.swamy.entity.User;
import com.swamy.model.UserModel;

@Component
public interface Service {
	User registerUser(UserModel userModel);
	List<User> getusers();
	
}
