package com.zhiyou100.ssh.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh.model.Admin;
import com.zhiyou100.ssh.service.AdminUserService;
@Controller("adminUserAction")
@Scope(scopeName="prototype")
public class AdminUserAction  extends ActionSupport implements ModelDriven<Admin>{

	@Autowired
	AdminUserService aus;
	
	private Admin admin = new Admin();

	public String adminindex() {
		return SUCCESS;
	}
	public String adminUser(){
		 Admin a = aus.fandUser(admin);
		 String str = null;
		 if(a == null){
			 //aus.addAdminUser(admin);
		     ActionContext.getContext().put("message", "登录错误,请重新登录");
			 str=ERROR;
		 }else{
			str= SUCCESS;
		 }
		return str;
	}

	@Override
	public Admin getModel() {
		
		return admin;
	}
	
	
	public String logoutUser(){
		
		
		
		return SUCCESS;
	}
	
	
	
	
	
}
