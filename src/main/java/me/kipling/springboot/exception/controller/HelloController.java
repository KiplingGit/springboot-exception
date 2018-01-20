package me.kipling.springboot.exception.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.kipling.springboot.exception.common.TestException;

/**
 * 测试
 * 
 * 
 * @author uatwz90560
 *
 */
@RestController
public class HelloController {

	protected static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/")
	String home() {
		logger.debug("访问home");
		return "Hello World!";
	}

	@RequestMapping("/hello/{myName}")
	String index(@PathVariable String myName) {
		logger.debug("访问helloName,Name={}", myName);
		return "Hello " + myName + "!!!";
	}

	@RequestMapping("/hello2")
	public String hello() {
		// 自己编写的除0异常
		int a = 1 / 0;
		return "hello1";
	}

	/*// 局部异常处理
	@ExceptionHandler(Exception.class)
	public String exHandler(Exception e) {
		// 判断发生异常的类型是除0异常则做出响应
		if (e instanceof ArithmeticException) {
			return "发生了除0异常";
		}
		// 未知的异常做出响应
		return "发生了未知异常";
	}*/
}
