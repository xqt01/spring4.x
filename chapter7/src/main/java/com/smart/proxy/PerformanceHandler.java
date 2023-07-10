package com.smart.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理实现
 */
public class PerformanceHandler implements InvocationHandler {

	/**
	 * 目标业务类
	 */
    private Object target;

	public PerformanceHandler(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
		// 反射调用目标方法时间
		Object obj = method.invoke(target, args);
		PerformanceMonitor.end();
		return obj;
	}
}
