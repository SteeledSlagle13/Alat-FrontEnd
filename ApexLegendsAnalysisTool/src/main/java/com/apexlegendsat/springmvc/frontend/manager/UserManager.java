package com.apexlegendsat.springmvc.frontend.manager;

import java.util.List;

import com.apexlegendsat.springmvc.frontend.view.UserView;

public interface UserManager {
	
	void deleteUserById(int id);
	
	public boolean doesUserExist(UserView user);

	List<UserView> findAllUsers();
	
	UserView findById(int id);

	UserView findByName(String name);
	
	void saveUser(UserView user);

	void updateUser(UserView user);

}
