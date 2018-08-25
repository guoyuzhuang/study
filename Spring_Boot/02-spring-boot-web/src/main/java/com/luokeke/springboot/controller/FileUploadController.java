package com.luokeke.springboot.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传类
 * @author guoyuzhuang
 *
 */
@RestController
public class FileUploadController {

	@RequestMapping(value = "/uploadfile")
	public Map<String, Object> uploadfile(MultipartFile filename) throws Exception {
		System.out.println("文件名称：" + filename.getOriginalFilename());
		filename.transferTo(new File("E:/tmp/" + filename.getOriginalFilename()));
		Map<String, Object> map = new HashMap<>();
		map.put("result", "OK");
		return map;
	}
}
