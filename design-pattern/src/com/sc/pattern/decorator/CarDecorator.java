package com.sc.pattern.decorator;

public class CarDecorator implements Car {
	protected Car car;

	public CarDecorator(Car c) {
		this.car = c;
	}

	@Override
	public void feature() {
		this.car.feature();
	}

}
