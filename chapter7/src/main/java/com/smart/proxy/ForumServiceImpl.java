package com.smart.proxy;

public class ForumServiceImpl implements ForumService {

    @Override
    public void removeTopic(int topicId) {
        PerformanceMonitor.begin("com.smart.proxy.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除Topic记录:" + topicId);
        try {
            Thread.sleep(20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
        PerformanceMonitor.begin("com.smart.proxy.ForumServiceImpl.removeForum");
        System.out.println("模拟删除Forum记录:" + forumId);
        try {
            Thread.sleep(40);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        PerformanceMonitor.end();
    }
}
