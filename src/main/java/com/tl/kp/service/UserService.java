package com.tl.kp.service;

import com.tl.kp.model.User;

public interface UserService {
	
	public User getLogin(String userName,String userPassword);

}
