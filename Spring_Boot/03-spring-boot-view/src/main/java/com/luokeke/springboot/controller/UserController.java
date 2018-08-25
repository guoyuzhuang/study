package com.luokeke.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/showUser")
	public String showUser(Model model) {
		List<Users> list = new ArrayList<Users>();
		list.add(new Users(1, "zhangsan", 20));
		list.add(new Users(2, "李四", 22));
		list.add(new Users(3, "王五", 24));
		model.addAttribute("list", list);
		return "userList";
	}
	
	@RequestMapping("/showUserFreeMarker")
	public String showUserFreeMarker(Model model) {
		List<Users> list = new ArrayList<Users>();
		list.add(new Users(1, "zhangsan", 20));
		list.add(new Users(2, "李四", 22));
		list.add(new Users(3, "王五", 24));
		model.addAttribute("list", list);
		return "userListFreeMarker";
	}
}
