package com.smart.context;

import com.smart.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * Groovy DSL方式装配Bean
 * @author Harry Zhang
 * @since 2023-05-25
 */
public class GroovyApplicationContextTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericGroovyApplicationContext("classpath:com/smart/context/groovy-beans.groovy");
        Car car = (Car) ctx.getBean("car");
        car.introduce();
    }
}
