package com.luokeke.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}

	/**
	 * 设置session
	 * @param session
	 * @return
	 */
	@RequestMapping("/setSession")
	@ResponseBody
	public String setSession(HttpSession session) {
		session.setAttribute("key", "luokeke");
		return "hello";
	}

	/**
	 * 获取session值并且打印
	 * @param session
	 * @return
	 */
	@RequestMapping("/getSession")
	@ResponseBody
	public String getSession(HttpSession session) {
		System.out.println("Spring Boot获取session的值：" + session.getAttribute("key"));
		return "hello";
	}
}
