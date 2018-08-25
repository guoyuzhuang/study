package com.luokeke.springboot.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(filterName="FirstFilter",urlPatterns={"*.do","*.jsp"})
public class Filter2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init filter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入filter2");
		chain.doFilter(request, response);
		System.out.println("退出filter2");
	}

	@Override
	public void destroy() {
		System.out.println("this is destory");
	}

}
