package com.jts.pattern.decorator;

public class UpgardeFeatureV1 extends CarDecorator {

	public UpgardeFeatureV1(Car c) {
		super(c);
	}
	
	@Override
	public void feature() {
		super.feature();
		System.out.println("Upgraded Version from Model Feature to V1.");
	}

}
