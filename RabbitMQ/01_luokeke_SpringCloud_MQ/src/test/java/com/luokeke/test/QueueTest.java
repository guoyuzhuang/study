package com.luokeke.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.luokeke.Sender;
import com.luokeke.SpringBootServerApplication;

/**
 * 消息队列测试类
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringBootServerApplication.class)
public class QueueTest {

	@Autowired
	private Sender sender;
	
	/*
	 * 测试消息队列
	 */
	@Test
	public void test1() throws InterruptedException{
		while (true) {
			this.sender.send("Hello RabbitMQ-ccmc");
			this.sender.send("Hello RabbitMQ-qweqe");
			this.sender.send("Hello RabbitMQ-cxvxcv");
			this.sender.send("Hello RabbitMQ-234234");
			Thread.sleep(200);
		}
	}
}
