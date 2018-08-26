package com.luokeke.db.junit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luokeke.jpa.Application;
import com.luokeke.jpa.dao.UsersRepositoryPagingAndSorting;
import com.luokeke.jpa.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })
public class UsersRepositoryPagingAndSortingTest {

	@Autowired
	private UsersRepositoryPagingAndSorting repositoryPagingAndSorting;

	/**
	 * PagingAndSortingRepository   分页测试
	 */
	@Test
	public void testPagingAndSortingRepositoryPaging() {
		//Pageable:封装了分页的参数，当前页，每页显示的条数。注意：他的当前页是从0开始。
		//PageRequest(page,size) page:当前页。size:每页显示的条数
		Pageable pageable = new PageRequest(2, 5);
		Page<Users> page = this.repositoryPagingAndSorting.findAll(pageable);
		System.out.println("总条数：" + page.getTotalElements());
		System.out.println("总页数" + page.getTotalPages());
		List<Users> list = page.getContent();
		for (Users users : list) {
			System.out.println(users);
		}
	}

	/**
	 * 分页并排序查询
	 */
	@Test
	public void testFindAll() {
		Sort sort = new Sort(new Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(2, 4, sort);
		Page<Users> page = this.repositoryPagingAndSorting.findAll(pageable);
		System.out.println("总条数：" + page.getTotalElements());
		System.out.println("总页数" + page.getTotalPages());
		List<Users> list = page.getContent();
		for (Users users : list) {
			System.out.println(users);
		}
	}
}
