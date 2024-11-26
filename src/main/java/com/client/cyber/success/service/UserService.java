package com.client.cyber.success.service;

import java.util.List;

import com.client.cyber.success.model.User;



public interface UserService {
	User createUser(User user);
	public User getLogin(String userName,String userPassword);
	User updateUser(User user,Integer userId);
	User getUserById(Integer userId);
	List<User> getAllUsers();
	void deleteUser(Integer userId);

}
