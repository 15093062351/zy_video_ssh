package com.zhiyou100.ssh.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	
	    private Integer id;

	    private String nickName;

	    private Integer sex;

	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date birthday;

	    private String email;

	    private String province;

	    private String city;

	    private String headUrl;

	    private String password;

	    private Date insertTime;

	    private Date updateTime;

	    private String captcha;
	    
	    
	    

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNickName() {
			return nickName;
		}

		public void setNickName(String nickName) {
			this.nickName = nickName;
		}

		public Integer getSex() {
			return sex;
		}

		public void setSex(Integer sex) {
			this.sex = sex;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getHeadUrl() {
			return headUrl;
		}

		public void setHeadUrl(String headUrl) {
			this.headUrl = headUrl;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Date getInsertTime() {
			return insertTime;
		}

		public void setInsertTime(Date insertTime) {
			this.insertTime = insertTime;
		}

		public Date getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}

		public String getCaptcha() {
			return captcha;
		}

		public void setCaptcha(String captcha) {
			this.captcha = captcha;
		}
		public void setProperty(User u) {
			this.nickName = u.getNickName() == null?this.getNickName():u.getNickName();
			this.sex = u.getSex() == null?this.getSex():u.getSex();
			this.birthday = u.getBirthday() == null?this.getBirthday():u.getBirthday();
			this.email = u.getEmail() == null?this.getEmail():u.getEmail();
			this.province = u.getProvince() == null?this.getProvince():u.getProvince();
			this.city = u.getCity() == null?this.getCity():u.getCity();
			this.headUrl = u.getHeadUrl() == null?this.getHeadUrl():u.getHeadUrl();
			this.password = u.getPassword() == null?this.getPassword():u.getPassword();
			this.insertTime = u.getInsertTime() == null?this.getInsertTime():u.getInsertTime();
			this.updateTime = u.getUpdateTime() == null?this.getUpdateTime():u.getUpdateTime();
			this.captcha = u.getCaptcha() == null?this.getCaptcha():u.getCaptcha();
		}
		
		@Override
		public String toString() {
			return "User [id=" + id + ", nickName=" + nickName + ", sex=" + sex + ", birthday=" + birthday + ", email="
					+ email + ", province=" + province + ", city=" + city + ", headUrl=" + headUrl + ", password="
					+ password + ", insertTime=" + insertTime + ", updateTime=" + updateTime + ", captcha=" + captcha
					+ "]";
		}
	
	    
	    

}