package me.kipling.springboot.exception.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.kipling.springboot.exception.common.TestException;

/**
 * 加入TestException注解测试
 * 
 * 
 * @author uatwz90560
 *
 */
@TestException
@RestController
@RequestMapping("/test")
public class ExceptionTestController {

	protected static Logger logger = LoggerFactory.getLogger(ExceptionTestController.class);

	@RequestMapping("/hello1")
	public String hello() {
		// 自己编写的除0异常
		int a = 1 / 0;
		return "hello1";
	}
}
