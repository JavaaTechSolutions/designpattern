package com.jts.pattern.chainofres;

public class Process200Rs implements ChainProcessor {

	private ChainProcessor chain;

	@Override
	public void setNextChain(ChainProcessor nextChain) {
		chain = nextChain;
	}

	@Override
	public void process(int amount) {
		if (amount >= 200) {
			int num = amount / 200;
			int remainder = amount % 200;

			System.out.println(num + " 200 note dispensing");

			if (remainder != 0) {
				chain.process(remainder);
			}
		} else {
			chain.process(amount);
		}
	}

}
