package com.smart.beanprop;

import org.junit.Test;

/**
 * @author Harry Zhang
 * @since 2023-06-28
 */
public class SysConfigTest {

    @Test
    public void test() {
        SysConfig sysConfig = new SysConfig();
        sysConfig.initFromDB();
        System.out.println(sysConfig.getMaxTabPageNum());
        System.out.println(sysConfig.getSessionTimeout());
    }
}
