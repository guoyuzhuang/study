package com.luokeke.db.junit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.luokeke.jpa.Application;
import com.luokeke.jpa.dao.UsersRepositoryQueryAnnotation;
import com.luokeke.jpa.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })
public class UsersRepositoryQueryAnnotationTest {

	@Autowired
	private UsersRepositoryQueryAnnotation usersRepositoryQueryAnnotation;

	@Test
	public void testQuery() {
//		List<Users> list = usersRepositoryQueryAnnotation.queryByNameUseHQL("我不知道");
		List<Users> list = usersRepositoryQueryAnnotation.queryByNameUseSQL("我不知道");
		for (Users u : list) {
			System.out.println(u);
		}
	}
	
	@Test
	@Transactional//不添加该注释，无法开启事物，会报错
	@Rollback(false)//不添加这句注释，则修改sql执行之后不会提交，会自动回滚
	public void testUpdate() {
		usersRepositoryQueryAnnotation.updateUsersNameById("******", 2);
	}
}
