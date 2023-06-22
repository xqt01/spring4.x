package com.smart.editor;

public class Boss {
	private String name;
	private Car car = new Car();
	private NewCar newCar = new NewCar();

	@Override
	public String toString(){
		String temp ="name:"+name+"\n";
		temp += "car:" + car + "\n";
		temp += "CustomCar:" + newCar;
		return temp;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NewCar getCustomCar() {
		return newCar;
	}

	public void setCustomCar(NewCar newCar) {
		this.newCar = newCar;
	}
}
