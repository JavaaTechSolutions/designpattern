package com.sc.pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sc.pattern.singleton.EagerInitializedSingleton;
import com.sc.pattern.singleton.EnumSingleton;
import com.sc.pattern.singleton.LazyInitializedSingleton;
import com.sc.pattern.singleton.StaticBlockSingleton;
import com.sc.pattern.singleton.ThreadSafeSingleton;

public class EntryPoint {
	public static void main(String[] args) {
		EagerInitializedSingleton eagerObj1 = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton eagerObj2 = EagerInitializedSingleton.getInstance();

		System.out.println("Instances HashCode for Object 1 ::" + eagerObj1.hashCode());
		System.out.println("Instances HashCode for Object 2 ::" + eagerObj2.hashCode());

		StaticBlockSingleton staticBlockObj1 = StaticBlockSingleton.getInstance();
		StaticBlockSingleton staticBlockObj2 = StaticBlockSingleton.getInstance();

		System.out.println("Instances HashCode for Object 1 ::" + staticBlockObj1.hashCode());
		System.out.println("Instances HashCode for Object 2 ::" + staticBlockObj2.hashCode());

//		LazyInitializedSingleton lazyBlockObj1 = LazyInitializedSingleton.getInstance();
//		LazyInitializedSingleton lazyBlockObj2 = LazyInitializedSingleton.getInstance();
//
//		System.out.println("Instances HashCode for Object 1 ::" + lazyBlockObj1.hashCode());
//		System.out.println("Instances HashCode for Object 2 ::" + lazyBlockObj2.hashCode());

		ExecutorService service = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 5; i++) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					ThreadSafeSingleton threadObj = ThreadSafeSingleton.getInstance();
					System.out.println("Instances HashCode for multi threaded Object (Thread Safe) ::" + threadObj.hashCode());
				}
			});
		}

		for (int i = 0; i < 5; i++) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					LazyInitializedSingleton threadObj = LazyInitializedSingleton.getInstance();
					System.out.println("Instances HashCode for multi threaded Object ::" + threadObj.hashCode());
				}
			});
		}

		service.shutdown();
		
		EnumSingleton enumS1 = EnumSingleton.INSTANCE;
		EnumSingleton enumS2 = EnumSingleton.INSTANCE;
		System.out.println("Instances HashCode for enum Object ::" + enumS1.hashCode());
		System.out.println("Instances HashCode for enum Object ::" + enumS2.hashCode());
		
	}
}
