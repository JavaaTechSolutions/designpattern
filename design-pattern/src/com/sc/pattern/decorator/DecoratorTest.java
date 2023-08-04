package com.sc.pattern.decorator;

public class DecoratorTest {
	public static void main(String[] args) {
		System.out.println("================ V1 ============");
		
		Car v1Car = new UpgardeFeatureV1(new BasicFeature());
		v1Car.feature();
		
		System.out.println("================ V2 ============");
		
		Car v2Car = new UpgardeFeatureV1(new UpgardeFeatureV2(new BasicFeature()));
		v2Car.feature();
	}
}
