package com.luokeke.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luokeke.db.dao.UsersRepository;
import com.luokeke.db.entity.Users;
import com.luokeke.db.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public List<Users> findUserAll() {
		return this.usersRepository.findAll();
	}

	@Override
	@Cacheable(value="users")
	public Users findUserById(Integer id) {
		return this.usersRepository.findOne(id);
	}

	@Override
	public Page<Users> findUserByPage(Pageable pageable) {
		return this.usersRepository.findAll(pageable);
	}

	@Override
	public void saveUsers(Users users) {
		this.usersRepository.save(users);
	}
}
