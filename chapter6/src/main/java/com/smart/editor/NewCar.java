package com.smart.editor;

/**
 * @author huanruiz
 * @since 2023/6/22
 */
public class NewCar {

    private int maxSpeed;
    public String brand;
    private double price;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "new car-brand:"+brand+"/maxSpeed:"+maxSpeed+"/price:"+price;
    }
}
