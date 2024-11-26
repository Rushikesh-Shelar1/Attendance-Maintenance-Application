package com.tl.kp.service;

import java.util.List;

import com.tl.kp.model.Admin;
import com.tl.kp.model.User;


public interface AdminService {
	
	public Admin addAdmin(Admin admin);
	public List<User> getAllUser();

}
