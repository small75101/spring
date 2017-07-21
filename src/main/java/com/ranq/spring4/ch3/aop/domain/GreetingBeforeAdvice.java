package com.ranq.spring4.ch3.aop.domain;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object obj) throws Throwable {
		System.out.println("=============================  =============================");
		String clientName = (String) args[0];
		System.out.println("How are you ! MR." + clientName + ".");
	}
}
