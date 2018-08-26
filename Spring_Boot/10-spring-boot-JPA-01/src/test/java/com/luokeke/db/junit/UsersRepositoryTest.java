package com.luokeke.db.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luokeke.jpa.Application;
import com.luokeke.jpa.dao.UsersRepository;
import com.luokeke.jpa.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })
public class UsersRepositoryTest {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Test
	public void testSave() {
		Users users = new Users();
		users.setAddress("北京市海淀");
		users.setAge(20);
		users.setName("张三");
		this.usersRepository.save(users);
	}
}
