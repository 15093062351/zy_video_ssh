package com.zhiyou100.ssh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zhiyou100.ssh.dao.AdminUserDao;
import com.zhiyou100.ssh.model.Admin;

public class AdminUserDaoImpl extends HibernateDaoSupport implements AdminUserDao {

	@Override
	public void addAdminUser(Admin admin) {
		getHibernateTemplate().save(admin);
	}

	@Override
	public Admin fandUser(Admin admin) {
	///Admin   a  = (Admin) getHibernateTemplate().find("from Admin where loginName = ? and loginPwd = ? ", admin.getLoginName(),admin.getLoginPwd());
		List<Admin> list   = (List<Admin>) getHibernateTemplate().find("from Admin where loginName = ? and loginPwd = ? ", admin.getLoginName(),admin.getLoginPwd());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}

	
	
	
	
	
	
	
	
	
	
}
