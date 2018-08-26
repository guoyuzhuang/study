package com.luokeke.db.junit;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luokeke.db.Application;
import com.luokeke.db.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })
public class Test {

	@Autowired
	private UsersService usersService;

	@org.junit.Test
	public void testFindUserById() {
		try {
			//第一次查询 
			System.out.println(this.usersService.findUserById(1));
			//第二次查询 
			System.out.println(this.usersService.findUserById(1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
