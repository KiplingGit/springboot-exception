package me.kipling.springboot.exception.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1、现在习惯使用ajax的方式发起请求，所以经常需要服务端返回一个json或者字符串。 
 * 
 * 2、控制全局的异常处理。
 * 
 * 3、如果在单个方法中使用try，catch把方法包裹起来，工作量大，而且会异常的抛出而导致@Transactional注解的方法事务不会回滚。
 * 
 * @author uatwz90560
 *
 */
@RequestMapping("/test1")
@RestController
public class TestController {

	protected static Logger logger = LoggerFactory.getLogger(TestController.class);

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

	/*
	 * // 局部异常处理
	 * 
	 * @ExceptionHandler(Exception.class) public String exHandler(Exception e) {
	 * // 判断发生异常的类型是除0异常则做出响应 if (e instanceof ArithmeticException) { return
	 * "发生了除0异常"; } // 未知的异常做出响应 return "发生了未知异常"; }
	 */
}
