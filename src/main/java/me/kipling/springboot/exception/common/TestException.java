package me.kipling.springboot.exception.common;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

// 这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射
@Retention(RUNTIME)
// 目标类型可以应用在方法
@Target(ElementType.TYPE)
// 对doc文档支持
@Documented
public @interface TestException {
	
}