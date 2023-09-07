package com.jts.pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.jts.pattern.singleton.EagerSigleton;
import com.jts.pattern.singleton.EnumSinglton;
import com.jts.pattern.singleton.LazyInitializationSigleton;
import com.jts.pattern.singleton.ThreadSafeLazyInitializationSigleton;

public class EntryPoint {

	public static void main(String[] args) {
		EagerSigleton eagerObject1 = EagerSigleton.getInstance();
		EagerSigleton eagerObject2 = EagerSigleton.getInstance();

		System.out.println("Egaer Object 1::" + eagerObject1.hashCode());
		System.out.println("Egaer Object 2::" + eagerObject2.hashCode());

		EnumSinglton enumObj = EnumSinglton.INSTANCE;

		System.out.println("Enum Object 1::" + enumObj.hashCode());

//		LazyInitializationSigleton lazyObject1 = LazyInitializationSigleton.getInstance();
//		LazyInitializationSigleton lazyObject2 = LazyInitializationSigleton.getInstance();
//
//		System.out.println("Lazy Object 1::" + lazyObject1.hashCode());
//		System.out.println("Lazy Object 2::" + lazyObject2.hashCode());

		ExecutorService service = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 5; ++i) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					ThreadSafeLazyInitializationSigleton lazyObject1 = ThreadSafeLazyInitializationSigleton
							.getInstanceWithDoubleLocking();

					System.out.println("Lazy Object creation using multi thread::" + lazyObject1.hashCode());

				}
			});
		}

		service.shutdown();
	}
}
