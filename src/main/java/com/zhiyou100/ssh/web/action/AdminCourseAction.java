package com.zhiyou100.ssh.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh.model.Course;
import com.zhiyou100.ssh.model.Subject;
import com.zhiyou100.ssh.service.AdminCourseService;

@Controller("adminCourseAction")
@Scope(scopeName="prototype")
public class AdminCourseAction extends ActionSupport implements ModelDriven<Course>{
	@Autowired
	AdminCourseService acs;
	
	
	private Course course = new Course ();
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String courseList() {
		List<Course> courses =acs.findCourse();
		ActionContext.getContext().put("c", courses);
		return SUCCESS;
	}
	
	public String addcourse(){
		
		List<Subject> subject = acs.findSubject();
		ActionContext.getContext().put("list", subject);
		return SUCCESS;
	}

	@Override
	public Course getModel() {
		
		return course;
	}
	
	public String addcoursebaocun(){
		acs.addCourse(course);
		return SUCCESS;
	}
	public String editcourse(){
		List<Subject> subject = acs.findSubject();
		ActionContext.getContext().put("list", subject);
		
		Course course2 = acs.findcourse(course.getId());
		ActionContext.getContext().put("course2", course2);
		
		return SUCCESS;
	}
	public String editcoursebaocun(){
		acs.updateCourse(course);
		return SUCCESS;
	}
	//删除课程
	public String deletecourse(){
		
		
		Course findcourse = acs.findcourse(course.getId());
		
		acs.deleteCourse(findcourse);
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
}



















