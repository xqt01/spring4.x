package com.smart.proxy;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class ForumServiceTest {

    @Test
    public void proxy() {
        // 业务类正常编码的测试
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);

        // 使用JDK动态代理
//		ForumService target = new ForumServiceImpl();
//		PerformanceHandler handler = new PerformanceHandler(target);
//		// 让PerformanceHandler将性能监视横切逻辑编织到ForumService实例中
//		ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
//		proxy.removeForum(10);
//		proxy.removeTopic(1012);

        // 使用CGLib动态代理
//		CglibProxy cglibProxy = new CglibProxy();
//		ForumService forumService = (ForumService)cglibProxy.getProxy(ForumServiceImpl.class);
//		forumService.removeForum(10);
//		forumService.removeTopic(1023);
    }
}
