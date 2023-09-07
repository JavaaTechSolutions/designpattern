package com.jts.pattern.singleton;

public class LazyInitializationSigleton {

	private static LazyInitializationSigleton instance;

	private LazyInitializationSigleton() {

	}

	public static LazyInitializationSigleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializationSigleton();
		}

		return instance;
	}
}
