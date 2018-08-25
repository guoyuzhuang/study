package com.luokeke.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luokeke.db.entity.Users;
import com.luokeke.db.service.UsersService;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private UsersService usersService;
	
	//页面跳转
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
	/**
	 * 添加用户信息
	 * @param users
	 * @return
	 */
	@RequestMapping("/saveUsers")
	public String saveUsers(Users users) {
		usersService.addUsers(users);
		return "OK";
	}
	@RequestMapping("/test")
	public String test() {
		usersService.test();
		return "OK";
	}
}
