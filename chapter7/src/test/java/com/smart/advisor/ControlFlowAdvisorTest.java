package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * 对所有WaiterDelegate#service()方法发起调用的其他方法都织入GreetingBeforeAdvice
 */
public class ControlFlowAdvisorTest {

	@Test
	public void control() {
		String configPath = "com/smart/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter) ctx.getBean("waiter3");
		WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);
		waiter.serveTo("Peter");
		waiter.greetTo("Peter");
		wd.service("Peter");
	}
}
