package com.swamy.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.entity.User;
import com.swamy.model.UserModel;
import com.swamy.services.Service;
@RestController
@RequestMapping("api/users/")
@CrossOrigin(origins = "https://partial-gmail-clone-app.herokuapp.com/")
public class UserRestControlller {
	
	@Autowired
	private Service service;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody UserModel userModel) {
		return service.registerUser(userModel);
	}
	@GetMapping("/")
	public List<User> getUsers(){
		return service.getusers();
	}
	
	

}
