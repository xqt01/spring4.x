package com.smart.aspectj.basic;

import com.smart.Seller;
import com.smart.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {
   /**
    * 为NaiveWaiter添加接口实现
    */
    @DeclareParents(value = "com.smart.NaiveWaiter", defaultImpl = SmartSeller.class)
    public Seller seller;
}
