package com.luokeke.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luokeke.db.entity.Users;
import com.luokeke.db.mapper.UsersMapper;
import com.luokeke.db.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersMapper usersMapper;

	public void addUsers(Users users) {
		usersMapper.insertUsers(users);
	}

	@Override
	public void test() {
		Users users = usersMapper.queryUsers(6);
		System.out.println(users.toString());
	}

}
