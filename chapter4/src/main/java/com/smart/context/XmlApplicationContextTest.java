package com.smart.context;

import com.smart.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harry Zhang
 * @since 2023-05-29
 */
public class XmlApplicationContextTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"com/smart/context/beans.xml"});
        Car car = (Car) ctx.getBean("car");
        car.introduce();
    }
}
