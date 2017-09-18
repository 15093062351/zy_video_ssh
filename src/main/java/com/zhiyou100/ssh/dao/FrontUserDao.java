package com.zhiyou100.ssh.dao;

import com.zhiyou100.ssh.model.User;

public interface FrontUserDao {

	User findUser(User user);

	User findUserBy(String email);

	void addUser(User user);

	void updateUser(User user);

	User findUserBy(Integer id);


}
