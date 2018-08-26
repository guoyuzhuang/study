	package com.luokeke.jpa.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.luokeke.jpa.pojo.Users;

/**
 * Repository 接口的方法名称命名查询
 * @author guoyuzhuang
 *
 */
public interface UsersRepositoryByName extends Repository<Users, Integer> {

	/**
	 * 方法的名称，必须要遵循驼峰式命名
	 * findBy{属性名称，首字母要大写}
	 * @param name
	 * @return
	 */
	public List<Users> findByName(String name);
	
	/**
	 * 根据名称和年龄进行查询
	 * @param name
	 * @param age
	 * @return
	 */
	public List<Users> findByNameAndAge(String name, Integer age);
	public List<Users> findByNameOrAge(String name, Integer age);
	public List<Users> findByNameLike(String name);
}
