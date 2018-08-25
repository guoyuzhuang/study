package com.luokeke.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luokeke.db.mapper")//扫描指定位置下面的所有Mapper
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
