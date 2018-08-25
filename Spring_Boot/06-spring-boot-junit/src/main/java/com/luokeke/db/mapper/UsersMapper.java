package com.luokeke.db.mapper;

import com.luokeke.db.entity.Users;

public interface UsersMapper {

	public void insertUsers(Users users);
	
	public Users queryUsers(Integer age);
}
