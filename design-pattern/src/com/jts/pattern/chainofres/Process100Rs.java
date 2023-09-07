package com.jts.pattern.chainofres;

public class Process100Rs implements ChainProcessor {
	
	private ChainProcessor chain;

	@Override
	public void setNextChain(ChainProcessor nextChain) {
		chain = nextChain;
	}

	@Override
	public void process(int amount) {
		if (amount >= 100) {
			int num = amount /100;
			int remainder = amount % 100;
			
			System.out.println(num + " 100 note dispensing");
			
			if (remainder != 0) {
				chain.process(remainder);
			}
		} else {
			chain.process(amount);
		}
	}

}
