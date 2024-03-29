package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class ComposableAdvisorTest {

	@Test
	public void composable() {
		String configPath = "com/smart/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter) ctx.getBean("waiter4");
		WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);
		waiter.serveTo("Peter");
		waiter.greetTo("Peter");
		wd.service("Peter");
	}
}
