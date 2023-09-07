package com.jts.pattern.chainofres;

public class Process500Rs implements ChainProcessor {

	private ChainProcessor chain;

	@Override
	public void setNextChain(ChainProcessor nextChain) {
		chain = nextChain;
	}

	@Override
	public void process(int amount) {
		if (amount >= 500) {
			int num = amount / 500;
			int remainder = amount % 500;

			System.out.println(num + " 500 note dispensing");

			if (remainder != 0) {
				chain.process(remainder);
			}
		} else {
			chain.process(amount);
		}
	}

}
