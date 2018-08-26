package com.luokeke.jpa.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.luokeke.jpa.pojo.Users;

public interface UsersRepositoryPagingAndSorting extends PagingAndSortingRepository<Users, Integer> {

}
