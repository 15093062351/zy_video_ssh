package com.zhiyou100.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh.dao.FrontUserDao;
import com.zhiyou100.ssh.model.User;
import com.zhiyou100.ssh.service.FrontUserService;
@Service
public class FrontUserServiceImpl implements FrontUserService {
    @Autowired
	FrontUserDao fud;

	@Override
	public User findUser(User user) {
		return fud.findUser(user);
	}

	@Override
	public User findUserBy(String email) {
		
		return fud.findUserBy(email);
	}

	@Override
	public void addUser(User user) {
		fud.addUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		System.out.println(33);
		fud.updateUser(user);
		System.out.println(44);
	}

	@Override
	public User findUserBy(Integer id) {
		
		return fud.findUserBy(id);
	}

	
    
    
    
    
    
    
    
	
}
