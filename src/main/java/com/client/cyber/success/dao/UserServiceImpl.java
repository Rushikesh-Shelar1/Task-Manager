package com.client.cyber.success.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.cyber.success.model.User;
import com.client.cyber.success.repository.UserRepo;
import com.client.cyber.success.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getLogin(String userName, String userPassword) {
		User user =userRepo.getLogin(userName, userPassword);
		if(user!=null) {
			return user;
			
		}
		else {
			System.out.println("Invalid credentials");
			return null;
		}
		
	}

}
