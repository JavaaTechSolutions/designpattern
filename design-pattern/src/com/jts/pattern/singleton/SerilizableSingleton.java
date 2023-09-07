package com.jts.pattern.singleton;

import java.io.Serializable;

public class SerilizableSingleton implements Serializable {

	private static final long serialVersionUID = -1707651967843418645L;

	private SerilizableSingleton() {

	}

	private static class SignletonHelper {
		private static final SerilizableSingleton instance = new SerilizableSingleton();
	}

	public static SerilizableSingleton getInstance() {
		return SignletonHelper.instance;
	}

	protected Object readResolve() {
		return getInstance();
	}
}
