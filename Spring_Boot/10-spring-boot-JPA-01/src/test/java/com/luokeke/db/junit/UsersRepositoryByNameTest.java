package com.luokeke.db.junit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luokeke.jpa.Application;
import com.luokeke.jpa.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })
public class UsersRepositoryByNameTest {
	
	@Autowired
	private com.luokeke.jpa.dao.UsersRepositoryByName usersRepositoryByName;

	@Test
	public void UsersRepositoryByName() {
		List<Users> list = usersRepositoryByName.findByName("我不知道");
		for (Users u : list) {
			System.out.println(u);
		}
	}
	
	@Test
	public void findByNameAndAge() {
		List<Users> list = usersRepositoryByName.findByNameAndAge("我不知道", 1001);
		for (Users u : list) {
			System.out.println(u);
		}
	}
	
	@Test
	public void test() {
//		List<Users> list = usersRepositoryByName.findByNameOrAge("我不知道", 1001);
		List<Users> list = usersRepositoryByName.findByNameLike("%道%");
		for (Users u : list) {
			System.out.println(u);
		}
	}
}
