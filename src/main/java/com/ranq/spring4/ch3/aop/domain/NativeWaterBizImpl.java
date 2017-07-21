package com.ranq.spring4.ch3.aop.domain;

public class NativeWaterBizImpl implements IWaterBiz {

	public void greetTo(String name) {
		System.out.println("greet to " + name + "...");
	}

	public void serveTo(String name) {

		System.out.println("serveTo to " + name + "...");
	}

}
