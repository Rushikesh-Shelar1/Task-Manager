package com.client.cyber.success.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.cyber.success.model.User;
import com.client.cyber.success.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Post-create user
	@PostMapping("/")
	public User createUser( @RequestBody User user){
		User createUser=userService.createUser(user);
		return createUser;
		
	}
	@PostMapping("/login")
	public String getLogin( @RequestBody User user) {
		User user1=	userService.getLogin(user.getUserName(), user.getPassword());
		if(user1!=null) {
			return "<h2><font color='green'>LoggedIn </font></h2>";
			
		}
		else {
			System.out.println("Invalid credentials");
			return "<h2><font color='red'>LoggedIn Unsuccesfully</font></h2>";		}
	
	}

}
