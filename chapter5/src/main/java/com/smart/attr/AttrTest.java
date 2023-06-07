package com.smart.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harry Zhang
 * @since 2023-06-07
 */
public class AttrTest {

    public static void main(String[] args) {
        //①父容器
        ClassPathXmlApplicationContext pFactory = new ClassPathXmlApplicationContext(new String[]{"com/smart/attr/beans1.xml"});
        //②指定pFactory为该容器的父容器
        ApplicationContext factory = new ClassPathXmlApplicationContext(new String[]{"com/smart/attr/beans2.xml"}, pFactory);
        Boss boss = (Boss) factory.getBean("boss");
        System.out.println(boss.getCar().toString());
    }
}
