package me.kipling.springboot.exception.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 因为404错误是不经过controller的，所以无法通过上述GlobalDefaultExceptionHandler办法处理。
 * 但是 SpringBoot 默认提供了一个全局的 handler 来处理所有的HTTP 错误, 并把它映射为 /error。
 * 当发生一个 HTTP 错误, 例如 404 错误时, SpringBoot 内部的机制会将页面重定向到
 * /error 中。
 * 
 * @author Kipling
 *
 */
@Controller
public class HttpErrorController implements ErrorController {

	private static final String ERROR_PATH = "/error";

	@RequestMapping(value = ERROR_PATH)
	public String handleError() {
		return "error/404";
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}

}