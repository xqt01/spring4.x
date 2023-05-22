package com.smart.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author huanruiz
 * @since 2023/5/22
 */
public class PrivateCarReflect {

    public static void main(String[] args) throws Throwable{
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.PrivateCar");

        PrivateCar pcar = (PrivateCar)clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");

        // 取消Java语言访问检查以访问private变量
        colorFld.setAccessible(true);
        colorFld.set(pcar, "红色");
        Method driveMtd = clazz.getDeclaredMethod("drive", (Class[])null);

        // 取消Java语言访问检查以访问protected方法
        driveMtd.setAccessible(true);
        // 调用方法
        driveMtd.invoke(pcar, (Object[])null);
    }
}
