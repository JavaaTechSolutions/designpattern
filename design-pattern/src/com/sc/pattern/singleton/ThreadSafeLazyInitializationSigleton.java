package com.sc.pattern.singleton;

public class ThreadSafeLazyInitializationSigleton {

	private static ThreadSafeLazyInitializationSigleton instance;

	private ThreadSafeLazyInitializationSigleton() {

	}

	public static synchronized ThreadSafeLazyInitializationSigleton getInstance() {
		if (instance == null) {
			instance = new ThreadSafeLazyInitializationSigleton();
		}

		return instance;
	}

	public static synchronized ThreadSafeLazyInitializationSigleton getInstanceWithDoubleLocking() {
		if (instance == null) {
			synchronized (ThreadSafeLazyInitializationSigleton.class) {
				if (instance == null) {
					instance = new ThreadSafeLazyInitializationSigleton();
				}
			}
		}

		return instance;
	}
}
