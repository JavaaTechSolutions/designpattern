package com.jts.pattern;

import java.lang.reflect.Constructor;
import java.util.Iterator;

import com.jts.pattern.singleton.EagerSigleton;

public class RefelctionSingletonTest {

	public static void main(String[] args) {
		EagerSigleton eagerSigleton = EagerSigleton.getInstance();
		EagerSigleton eagerSigleton2 = null;

		try {
			Constructor[] constructors = EagerSigleton.class.getDeclaredConstructors();
			
			for (Constructor constructor : constructors) {
				constructor.setAccessible(true);
				
				eagerSigleton2 = (EagerSigleton) constructor.newInstance();
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Instance 1::"+ eagerSigleton.hashCode());
		System.out.println("Instance 2::"+ eagerSigleton2.hashCode());

	}

}
