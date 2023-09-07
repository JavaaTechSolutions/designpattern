package com.jts.pattern.decorator;

public class UpgardeFeatureV2 extends CarDecorator {

	public UpgardeFeatureV2(Car c) {
		super(c);
	}
	
	@Override
	public void feature() {
		super.feature();
		System.out.println("Upgraded Version from Model Feature to V2.");
	}

}
