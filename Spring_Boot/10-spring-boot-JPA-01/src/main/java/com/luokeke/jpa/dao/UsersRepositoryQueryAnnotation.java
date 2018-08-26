package com.luokeke.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.luokeke.jpa.pojo.Users;

public interface UsersRepositoryQueryAnnotation extends Repository<Users,Integer> {

	@Query("from Users where name = ? ")
	public List<Users> queryByNameUseHQL(String name);
	
	//nativeQuery表示，前面的sql为标准的sql语句，不需要Hibernate再进行转换
	@Query(value = "select * from t_users where name = ? ", nativeQuery = true)
	public List<Users> queryByNameUseSQL(String name);
	

	@Query("update Users set name  = ? where id  = ?")
	@Modifying //需要执行一个更新操作，修改sql必须添加该注解，否则会报错
	public void updateUsersNameById(String name,Integer id);
}
