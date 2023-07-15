package com.sc.pattern.singleton;

public class StaticEagerSigleton {

	private static StaticEagerSigleton instance;

	private StaticEagerSigleton() {

	}

	static {
		try {
			instance = new StaticEagerSigleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured");
		}
	}

	public static StaticEagerSigleton getInstance() {
		return instance;
	}
}
