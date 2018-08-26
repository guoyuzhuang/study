package com.luokeke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping("/showPage")
	public String showPage(Model model) {
		model.addAttribute("msg", "this is msg message");
		System.out.println("彻底解决打印日志中文乱码问题");
		return "test";
	}
}
