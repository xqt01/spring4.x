package com.smart.resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

/**
 * 可自定义解码方式
 */
public class EncodedResourceExample {

	  public static void main(String[] args) throws Throwable  {
		  Resource res = new ClassPathResource("conf/file1.txt");
		  EncodedResource encRes = new EncodedResource(res,"UTF-8");
		  String content  = FileCopyUtils.copyToString(encRes.getReader());
		  System.out.println(content);  
	}
}
