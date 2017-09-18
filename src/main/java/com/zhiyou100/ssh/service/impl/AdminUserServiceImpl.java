package com.zhiyou100.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssh.dao.AdminUserDao;
import com.zhiyou100.ssh.model.Admin;
import com.zhiyou100.ssh.service.AdminUserService;
@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	AdminUserDao aud;

	@Override
	public void addAdminUser(Admin admin) {
		aud.addAdminUser(admin);
		
	}

	@Override
	public Admin fandUser(Admin admin) {
		
		return aud.fandUser(admin);
	}
	
}
