package com.smart.editor;

import java.beans.PropertyEditorSupport;

/**
 * @author huanruiz
 * @since 2023/6/22
 */
public class NewCarEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text){
        if (text == null || !text.contains(",")) {
            throw new IllegalArgumentException("设置的字符串格式不正确");
        }
        String[] infos = text.split(",");
        NewCar car = new NewCar();
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.parseInt(infos[1]));
        car.setPrice(Double.parseDouble(infos[2]));
        setValue(car);
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        if (value == null) {
            return "";
        } else {
            NewCar car = (NewCar) value;
            return car.getBrand() + "," + car.getMaxSpeed() + "," + car.getPrice();
        }
    }
}
