package com.tl.kp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tl.kp.model.Admin;
import com.tl.kp.model.User;
import com.tl.kp.repository.AdminRepository;
import com.tl.kp.repository.UserRepository;
import com.tl.kp.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepos;
	
	@Autowired
	private UserRepository userRepos;

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepos.save(admin);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepos.findAll() ;
	}

}
