package com.jts.pattern.chainofres;

public class MainProcessor {
	
	private ChainProcessor c1;
	
	public MainProcessor() {
		c1 = new Process500Rs();
		
		ChainProcessor rs200 = new Process200Rs();
		ChainProcessor rs100 = new Process100Rs();
		
		c1.setNextChain(rs200);
		rs200.setNextChain(rs100);
	}

	public static void main(String[] args) {
		MainProcessor process = new MainProcessor();
		
		process.c1.process(1800);
	}

}
