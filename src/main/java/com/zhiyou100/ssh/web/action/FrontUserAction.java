package com.zhiyou100.ssh.web.action;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.ssh.model.Course;
import com.zhiyou100.ssh.model.Result;
import com.zhiyou100.ssh.model.Speaker;
import com.zhiyou100.ssh.model.Subject;
import com.zhiyou100.ssh.model.User;
import com.zhiyou100.ssh.model.Video;
import com.zhiyou100.ssh.service.AdminCourseService;
import com.zhiyou100.ssh.service.FrontUserService;
import com.zhiyou100.ssh.util.MD5Utils;
import com.zhiyou100.ssh.util.MailUtil;

@Controller("frontUserAction")
@Scope(scopeName = "prototype")
public class FrontUserAction extends ActionSupport implements ModelDriven<User> {
	@Autowired
	FrontUserService fus;

	@Autowired
	AdminCourseService acs;

	private Integer subjectId;
	private Integer videoId;
	
	

	public Integer getVideoId() {
		return videoId;
	}
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	private String oldPassword;
	private String newPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	// 会生成一个临时文件
	private File upload;
	// 获取原始文件名
	private String uploadFileName;
	// 获取文件类型
	private String uploadContentType;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	private User user = new User();
	private Result result;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}

	public String indexjson() {
		/*
		 * result = new Result(); ass.deleteSpeaker(speaker);
		 * result.setSuccess(true); return SUCCESS;
		 */
		user.setPassword(MD5Utils.getMD5(user.getPassword()));
		User u = fus.findUser(user);
		// System.out.println(u);
		result = new Result();
		if (u != null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("_front_user", u);
			session.put("user", u);
			result.setSuccess(true);
			return SUCCESS;
		}
		result.setMsg("登录失败哦");
		return SUCCESS;
	}

	@Override
	public User getModel() {

		return user;
	}

	public String registjson() {
		user.setPassword(MD5Utils.getMD5(user.getPassword()));
		User us = fus.findUserBy(user.getEmail());
		result = new Result();
		if (us != null) {
			result.setMsg("不能注册");
			return SUCCESS;
		}
		fus.addUser(user);
		result.setSuccess(true);
		return SUCCESS;
	}

	// 跳转个人资料页面
	public String userlist() {

		return SUCCESS;
	}

	// 跳转修改资料
	public String updateprofile() {

		return SUCCESS;
	}

	// 修改资料 提交
	public String updateprofilebaocun() {
		User u = new User();
		user.setProperty(u);
		fus.updateUser(user);
		User user1 = fus.findUserBy(user.getId());
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("_front_user", user1);
		session.put("user", user1);
		return SUCCESS;
	}

	// 跳转到修改头像界面
	public String updateavatar() {
		return SUCCESS;
	}

	// 修改头像保存界面
	public String updateavatarbaocun() throws Exception {

		String str = UUID.randomUUID().toString().replaceAll("-", "");
		String extension = FilenameUtils.getExtension(uploadFileName);
		String strr = str + "." + extension;
		User user2 = fus.findUserBy(user.getId());
		user2.setHeadUrl(strr);
		fus.updateUser(user2);
		/*
		 * 将文件保存到指定目录 第一个参数表示 原始文件 第二个参数表示 目标文件
		 */
		FileUtils.copyFile(new File(upload.getAbsolutePath()), new File("d:\\upload\\" + str + "." + extension));

		User userBy = fus.findUserBy(user2.getId());
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("_front_user", userBy);
		session.put("user", userBy);
		return SUCCESS;

	}
	// 跳转密码安全界面

	public String updatepassword() {

		return SUCCESS;
	}

	// 修改密码保存界面
	public String updatepasswordbaocun() {

		User up = fus.findUserBy(user.getId());
		// user.setPassword(MD5Utils.getMD5(user.getPassword()));
		String md5 = MD5Utils.getMD5(oldPassword);
		String md5new = MD5Utils.getMD5(newPassword);
		// System.out.println(up+"数据库里面的密码");
		// System.out.println(md5+"旧密码加密的");
		// System.out.println(md5new+"新密码加密的");
		if (up.getPassword().equals(md5)) {
			System.out.println(55);
			up.setPassword(md5new);
			fus.updateUser(up);
		} else {
			ActionContext.getContext().put("message", "旧密码不正确");
		}
		return SUCCESS;
	}

	// 退出用户
	public String logoutUser() {
		System.out.println(777);
		Map<String, Object> session = ActionContext.getContext().getSession();
		/*
		 * User us = (User) session.get("user"); System.out.println(us);
		 */
		// session.remove(user);
		session.remove("_front_user");
		return SUCCESS;
	}

	// ajax 发送邮箱验证信息
	public String sendemailPwd() throws Exception {

		System.out.println(user.getEmail());
		Random ran = new Random();
		int a = ran.nextInt(9000) + 1000;
		User useremail = fus.findUserBy(user.getEmail());
		useremail.setCaptcha("" + a);
		fus.updateUser(useremail);
		MailUtil.send(user.getEmail(), "获取验证码", "" + a);
		result = new Result();
		result.setSuccess(true);
		return SUCCESS;
	}

	// 跳转忘记密码页面
	public String userforget_pwd() {

		return SUCCESS;
	}

	// 跳转重置密码页面
	public String userreset_pwd() {

		return SUCCESS;
	}

	// 重置密码保存界面
	public String userreset_pwdbaocun() {
		System.out.println(user + "------------------------------------------------");
		User useremails = fus.findUserBy(user.getEmail());
		System.out.println(useremails);
		useremails.setPassword(MD5Utils.getMD5(user.getPassword()));
		fus.updateUser(useremails);
		return SUCCESS;
	}

	// 跳转course 界面

	public String courseindex() {
		List<Course> courses = acs.findCourse(subjectId);
		System.out.println(courses);
		ActionContext.getContext().put("courses", courses);

		List<Subject> list = acs.findSubject();
		Subject subject = list.get(0);
		ActionContext.getContext().put("subject", subject);
		ActionContext.getContext().put("subjectId", subjectId);
		return SUCCESS;
	}
	
	//跳转video  界面
	public String videoindex(){
		List<Subject> list = acs.findSubject();
		Subject subject = list.get(0);
		
		System.out.println(videoId);
		ActionContext.getContext().put("subject", subject);
		ActionContext.getContext().put("subjectId", subjectId);
		ActionContext.getContext().put("videoId", videoId);
		return SUCCESS;
	}
	//显示video信息
	public String videoData(){
		
		
		Video video = acs.findVideoBy(videoId);
		ActionContext.getContext().put("video", video);
		ActionContext.getContext().put("subjectId", subjectId);
		Integer courseId = video.getCourseId();
		List<Video> videolist = acs.findVideoList(courseId);
		System.out.println(videolist);
		ActionContext.getContext().put("videoList", videolist);
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	

}
