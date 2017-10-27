package org.school.service.impl;

import java.util.List;

import javax.annotation.Resource;  

import org.school.mapper.UserMapper;
import org.school.model.User;
import org.school.service.UserService;
import org.springframework.stereotype.Service;  
  
@Service("UserService")  
public class UserServiceImpl implements UserService {  
    @Resource  
    private UserMapper userMapper;

	@Override
	public int delete(String username) {
		int result = userMapper.delete(username);
		return result;
	}

	@Override
	public int insert(User record) {
		int result = userMapper.insert(record);
		return result;
	}

	@Override
	public User select(String username) {
		User user = userMapper.select(username);
		return user;
	}

	@Override
	public int update(User record) {
		int result = userMapper.update(record);
		return result;
	}

	@Override
	public List<User> selectAll() {
		List<User> userList = userMapper.selectAll();
		return userList;
	}
}  