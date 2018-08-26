package com.luokeke.db.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luokeke.jpa.Application;
import com.luokeke.jpa.dao.UsersRepositoryCrudRepository;
import com.luokeke.jpa.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })
public class UsersRepositoryCrudRepositoryTest {

	@Autowired
	private UsersRepositoryCrudRepository repositoryCrudRepository;
	
	@Test
	public void saveUsers() {
		Users u = new Users();
		u.setAddress("新用户的地址是北京市");
		u.setAge(19);
		u.setName("洛可可1");
		repositoryCrudRepository.save(u);
	}
	
	@Test
	public void saveUsersList() {
		List<Users> list = new ArrayList<>();
		list.add(new Users("luokeke1", 18, "北京市1"));
		list.add(new Users("luokeke2", 19, "北京市2"));
		list.add(new Users("luokeke3", 20, "北京市3"));
		repositoryCrudRepository.save(list);
	}
	
	/**
	 * jpa新增数据时，先根据主键查询一次，如果查询到该数据，则执行修改操作
	 */
	@Test
	public void testUpdateUsers() {
		{
			Users u = new Users("luokeke3", 20, "北京市3--> 修改为北京市33");
			u.setId(18);
			repositoryCrudRepository.save(u);
		}
		{
			List<Users> list = new ArrayList<>();
			list.add(new Users(19, "luokeke1", 18, "北京市1--> 修改为北京市11"));
			list.add(new Users(20, "luokeke2", 19, "北京市2--> 修改为北京市22"));
			repositoryCrudRepository.save(list);
		}
	}
}
