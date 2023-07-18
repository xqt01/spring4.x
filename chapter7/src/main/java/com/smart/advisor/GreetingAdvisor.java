package com.smart.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

	/**
	 * 切点方法匹配规则
	 */
	public boolean matches(Method method, Class clazz) {
		return "greetTo".equals(method.getName());
	}

	/**
	 * 切点类匹配规则: 为Waiter的类或子类
	 */
	@Override
	public ClassFilter getClassFilter(){
		return new ClassFilter(){
			public boolean matches(Class clazz){
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}
}
