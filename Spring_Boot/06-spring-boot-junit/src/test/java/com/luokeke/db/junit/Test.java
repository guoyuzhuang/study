package com.luokeke.db.junit;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luokeke.db.Application;
import com.luokeke.db.entity.Users;
import com.luokeke.db.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })
public class Test {

	@Autowired
	private UsersService usersService;
	
	@org.junit.Test
	public void testadd() {
		Users users = new Users();
		users.setName("这个是验证用户名是否是中文，是否会出现乱码");
		users.setAge(1001);
		usersService.addUsers(users );
	}
}
