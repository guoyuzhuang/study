package com.luokeke.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.luokeke.jpa.pojo.Users;

public interface UsersRepositoryCrudRepository extends CrudRepository<Users, Integer> {

}
