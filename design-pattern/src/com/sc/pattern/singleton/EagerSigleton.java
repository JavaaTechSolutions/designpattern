package com.sc.pattern.singleton;

public class EagerSigleton {

	private static final EagerSigleton instance = new EagerSigleton();

	private EagerSigleton() {

	}

	public static EagerSigleton getInstance() {
		return instance;
	}
}
