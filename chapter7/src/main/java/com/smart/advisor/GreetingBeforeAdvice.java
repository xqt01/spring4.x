package com.smart.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object obj) {
		// 输出切点
		System.out.println(obj.getClass().getName() + "." + method.getName());
		String clientName = (String)args[0];
		System.out.println("How are you！Mr." + clientName + ".");
	}
}
