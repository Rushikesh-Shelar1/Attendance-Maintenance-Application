package com.tl.kp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tl.kp.model.User;
import com.tl.kp.repository.UserRepository;
import com.tl.kp.service.UserService;




@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repos;

	@Override
	public User getLogin(String userName, String userPassword) {
		
		User user =repos.getLogin(userName, userPassword);
		if(user!=null) {
			return user;
			
		}
		else {
			System.out.println("Invalid credentials");
			return null;
		}
	}
	
}
