package com.luokeke.springboot.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application_Servlet2 {

	public static void main(String[] args) {
		SpringApplication.run(Application_Servlet2.class, args);
	}

	@Bean
	public ServletRegistrationBean getServletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new Servlet2());
		bean.addUrlMappings("/second");
		return bean;
	}
	
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new Filter2());
		bean.addUrlPatterns("/second");
		return bean;
	}
}
