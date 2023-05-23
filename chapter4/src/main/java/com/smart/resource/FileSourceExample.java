package com.smart.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileSourceExample {
	
	public static void main(String[] args) {
		try {
			String filePath = "./chapter4/src/main/resources/conf/file1.txt";
			// PathResource访问任何可以通过URL/Path/系统文件路径表示的资源
			WritableResource res1 = new PathResource(filePath);
			// ClassPathResource访问类路径下的资源
			Resource res2 = new ClassPathResource("conf/file1.txt");

			OutputStream stream1 = res1.getOutputStream();
			stream1.write("欢迎光临\n小春论坛".getBytes());
			stream1.close();

            InputStream ins1 = res1.getInputStream();
			InputStream ins2 = res2.getInputStream();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int i;
			while((i=ins1.read()) != -1){
				baos.write(i);
			}
			System.out.println(baos.toString());

            System.out.println("res1:"+res1.getFilename());
            System.out.println("res2:"+res2.getFilename());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
