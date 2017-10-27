package org.school.service;

import java.util.List;

import org.school.model.User;

public interface UserService {
	int delete(String username);

	int insert(User record);

	User select(String username);
	
	List<User> selectAll();

	int update(User record);

}