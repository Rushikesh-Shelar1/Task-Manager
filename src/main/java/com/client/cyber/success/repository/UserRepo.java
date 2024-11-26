package com.client.cyber.success.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.client.cyber.success.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	 @Query("select u from User u where u.userName = :userName and u.password = :password")
	    User getLogin(@Param("userName") String userName, @Param("password") String password);

}
