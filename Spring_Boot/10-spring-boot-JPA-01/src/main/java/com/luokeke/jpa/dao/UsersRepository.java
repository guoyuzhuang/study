package com.luokeke.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luokeke.jpa.pojo.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {

}
