package com.smart.context
import com.smart.Car;

beans {
    car(Car) {//①名字（类型）
        brand = "红旗CA72" //②注入属性
        maxSpeed = "200"
        color = "red"
    }
}