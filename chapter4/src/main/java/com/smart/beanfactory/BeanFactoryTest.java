package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @author Harry Zhang
 * @since 2023-05-24
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:com/smart/beans.xml");
        System.out.println(res.getURL());

        //BeanFactory bf = new XmlBeanFactory(res);
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);

        // 通过Resource装载Spring配置信息并启动IoC容器
        reader.loadBeanDefinitions(res);
        System.out.println("init BeanFactory.");
        Car car = factory.getBean("car", Car.class);
        System.out.println("car bean is ready for use!");
        car.introduce();
    }
}
