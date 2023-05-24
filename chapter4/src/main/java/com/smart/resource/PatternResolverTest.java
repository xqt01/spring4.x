package com.smart.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @author Harry Zhang
 * @since 2023-05-24
 */
public class PatternResolverTest {

    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 加载所有类包com.smart以.xml为后缀的资源
        Resource resources[] =resolver.getResources("classpath:com/smart/**/*.xml");
        for(Resource resource : resources){
            System.out.println(resource.getDescription());
        }
    }
}
