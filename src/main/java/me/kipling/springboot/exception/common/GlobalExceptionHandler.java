package me.kipling.springboot.exception.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	/**
	 * 所有异常报错
	 * 
	 * @param request
	 * @param exception
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	public String allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		exception.printStackTrace();
		System.out.println("我报错了：" + exception.getLocalizedMessage());
		System.out.println("我报错了：" + exception.getCause());
		System.out.println("我报错了：" + exception.getSuppressed());
		System.out.println("我报错了：" + exception.getMessage());
		System.out.println("我报错了：" + exception.getStackTrace());
		//return "服务器异常，请联系管理员！";
		return "test";//注意此时的如果返回的视图如果找不到，就交给ErrorController处理
	}
}