package com.luokeke.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	/**
	 * themeleaf 入门学习
	 * @param model
	 * @return
	 */
	@RequestMapping("/thymeleaf")
	public String showUser(Model model) {
		model.addAttribute("msg", "张三李四王五");
		return "index";
	}
}
