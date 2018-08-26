package com.luokeke.db.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luokeke.redis.Application;
import com.luokeke.redis.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })
public class RedisTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@org.junit.Test
	public void testSet() {
		this.redisTemplate.opsForValue().set("luokeke", "洛可可");
		String value = (String) this.redisTemplate.opsForValue().get("luokeke");
		System.out.println(value);
	}

	/** * 获取一个字符串 */
	@org.junit.Test
	public void testGet() {
		String value = (String) this.redisTemplate.opsForValue().get("luokeke");
		System.out.println(value);
	}

	/**
	* 添加 Users 对象 
	*/
	@Test
	public void testSetUesrs() {
		Users users = new Users();
		users.setAge(20);
		users.setName("张三丰");
		users.setId(2); //重新设置序列化器 
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		this.redisTemplate.opsForValue().set("users", users);
	}

	/**
	 * 取 Users 对象
	 */
	@Test
	public void testGetUsers() {
		//重新设置序列化器
		this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		Users users = (Users) this.redisTemplate.opsForValue().get("users");
		System.out.println(users);
	}

	/**
	 * redis以json方式存储
	 */
	@Test
	public void testSetUsersUseJSON() {
		Users users = new Users();
		users.setAge(20);
		users.setName("张三丰");
		users.setId(2); //重新设置序列化器 
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		this.redisTemplate.opsForValue().set("users_json", users);
	}

	/**
	 *  基于 JSON 格式取 Users 对象 
	 */
	@Test
	public void testGetUsersUseJSON() {
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		Users users = (Users) this.redisTemplate.opsForValue().get("users_json");
		System.out.println(users);
	}
}
