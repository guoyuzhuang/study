package com.luokeke.springboot;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**  
	 * 文件上传配置  
	 * @return  
	 */
	/*@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//文件最大  
		factory.setMaxFileSize("204800KB"); //MB  
		/// 设置总上传数据总大小  
		factory.setMaxRequestSize("204800KB");
		return factory.createMultipartConfig();
	}*/
}
