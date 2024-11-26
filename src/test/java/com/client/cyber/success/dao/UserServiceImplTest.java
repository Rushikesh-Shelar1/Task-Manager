package com.client.cyber.success.dao;

import com.client.cyber.success.model.User;
import com.client.cyber.success.repository.UserRepo;
import com.client.cyber.success.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@SpringBootTest
class UserServiceImplTest {

    @MockBean
    private UserRepo userRepo;
    
    @Autowired
    private UserService userService;

//    @InjectMocks
//    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);
    	Optional<User> user=Optional.of(new User(1,"abc","xyz"));
    	Mockito.when(userRepo.findById(1)).thenReturn(user);
    	
    }

    @Test
    void testCreateUser() {
        User user = new User(1, "John Doe","password");
        when(userRepo.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertNotNull(createdUser);
        assertEquals("John Doe", createdUser.getUserName());
//        assertEquals("john.doe@example.com", createdUser.getEmail());
       // verify(userRepo, times(1)).save(user);
    }


    
    
    @Test
    void testGetUserById() {
//        Integer userId = 1;
//        User user = new User(userId, "John Doe", "password");
//        when(userRepo.findById(userId)).thenReturn(Optional.of(user));
//
//        User foundUser = userService.getUserById(userId);
//
//        assertNotNull(foundUser);
//        assertEquals("John Doe", foundUser.getUserName());
//       // assertEquals("john.doe@example.com", foundUser.getEmail());
//        verify(userRepo, times(1)).findById(userId);
    	
    	String user_name="abc";
    	User userById=userService.getUserById(1);
    	assertEquals(user_name, userById.getUserName());
    	
    }

//
    @Test
    void testDeleteUser() {
        Integer userId = 1;
        doNothing().when(userRepo).deleteById(userId);

        userService.deleteUser(userId);

        verify(userRepo, times(1)).deleteById(userId);
    }

    @Test
    void testGetLogin_Success() {
        String userName = "john.doe";
        String userPassword = "password";
        User user = new User(1, "John Doe", "john.doe@example.com");

        when(userRepo.getLogin(userName, userPassword)).thenReturn(user);

        User loggedInUser = userService.getLogin(userName, userPassword);

        assertNotNull(loggedInUser);
        assertEquals("John Doe", loggedInUser.getUserName());
        verify(userRepo, times(1)).getLogin(userName, userPassword);
    }

}
