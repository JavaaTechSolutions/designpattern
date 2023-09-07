package com.jts.pattern.chainofres;

public interface ChainProcessor {

	void setNextChain(ChainProcessor nextChain);

	void process(int amount);
}
