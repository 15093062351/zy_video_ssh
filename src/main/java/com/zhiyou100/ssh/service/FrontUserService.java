package com.zhiyou100.ssh.service;

import com.zhiyou100.ssh.model.User;

public interface FrontUserService {

	User findUser(User user);

	User findUserBy(String email);

	void addUser(User user);

	void updateUser(User user);

	User findUserBy(Integer id);



}
