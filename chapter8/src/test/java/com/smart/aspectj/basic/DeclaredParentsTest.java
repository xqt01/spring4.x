package com.smart.aspectj.basic;

import com.smart.Seller;
import com.smart.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class DeclaredParentsTest {

    @Test
    public void parent() {
        String configPath = "com/smart/aspectj/basic/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");
        // 可以成功地进行强制类型转换
        Seller seller = (Seller) waiter;
        seller.sell("Beer", "John");
    }
}
