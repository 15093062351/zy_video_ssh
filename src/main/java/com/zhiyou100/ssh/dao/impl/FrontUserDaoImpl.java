package com.zhiyou100.ssh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.ssh.dao.FrontUserDao;
import com.zhiyou100.ssh.model.User;

public class FrontUserDaoImpl extends HibernateDaoSupport implements FrontUserDao {

	@Override
	public User findUser(User user) {
		//System.out.println(user);
		List<User> list = (List<User>) getHibernateTemplate().find("from User where email = ? and password = ?", user.getEmail(),user.getPassword());
		//System.out.println(list);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public User findUserBy(String email) {
		
		List<User> list = (List<User>) getHibernateTemplate().find("from User where email = ?", email);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@Override
	public void addUser(User user) {
		getHibernateTemplate().save(user);
		
	}

	@Override
	public void updateUser(User user) {
		System.out.println(11);
		User us = getHibernateTemplate().get(User.class, user.getId());
		us.setProperty(user);
	}

	@Override
	public User findUserBy(Integer id) {
		List<User> list = (List<User>) getHibernateTemplate().find("from User where id = ?", id);
		User user = list.get(0);
		return user;
	}

	
	
	
	
	
	
}
