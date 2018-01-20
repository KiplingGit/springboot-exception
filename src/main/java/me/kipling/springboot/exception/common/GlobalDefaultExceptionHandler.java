package me.kipling.springboot.exception.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 在spring 3.2中,新增了@ControllerAdvice 注解可以用于定义@ExceptionHandler、@InitBinder、
 * @ModelAttribute,并应用到所有@RequestMapping中。
 * 
 * @ControllerAdvice的范围有： ①basePackages：应用在xx包 ②basePackageClasses：应用在xx类
 * ③assignableTypes：应用在加了@Controller的类 ④annotations：应用在带有xx注解的类或者方法
 * 
 * @ControllerAdvice(basePackages={"com.springboot.controller"})
 * 只捕捉com.springboot.controller包中的异常
 * 
 * @ControllerAdvice(basePackageClasses={TestController.class}) 只捕捉TestController.class中的异常
 * @ControllerAdvice(assignableTypes={TestController.class}) 只捕捉TestController.class中的异常
 * @ControllerAdvice(annotations=TestException.class) 只捕捉带有@TestException注解的类
 * 
 * 
 * 以下全局处理限制处理包含注解@TestException的组件
 * 
 * 注意如果异常被此Handler捕捉了，就不会在经过HellErrorController的处理,
 * 
 * 如果异常为此类不能处理或者异常为404等不能处理的异常，则交给HelloErrorController处理
 * 
 * @author Kipling
 *
 */
//@ControllerAdvice(annotations=TestException.class)
//@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	/*
	 * 全局异常处理返回字符串
	 * 
	 * 使用的时候注解@ExceptionHandler放开
	 * 
	 */
	// @ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> returnJson(Exception e) {
		/*
		 * // 判断发生异常的类型是除0异常则做出响应 if(e instanceof ArithmeticException){ return
		 * "全局：发生了除0异常"; } // 未知的异常做出响应 return "全局：发生了未知异常";
		 */

		Map<String, Object> map = new HashMap<String, Object>();
		// 判断发生异常的类型是除0异常则做出响应
		if (e instanceof ArithmeticException) {
			map.put("codeNumber", "1");
			map.put("message", e.getMessage());
			return map;
		}
		// 未知的异常做出响应
		map.put("codeNumber", "0");
		map.put("message", e.getMessage());
		return map;
	}

	@ExceptionHandler(Exception.class)
	public String returnPage(Exception e) {
		System.out.println(11111111);
		// 判断发生异常的类型是除0异常则做出响应
		if (e instanceof ArithmeticException) {
			// 跳转到test.jsp页面
			return "test";
		}
		// 未知的异常做出响应
		// 跳转到test.jsp页面
		return "test";
	}

}