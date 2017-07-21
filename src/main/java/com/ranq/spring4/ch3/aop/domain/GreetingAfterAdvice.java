package com.ranq.spring4.ch3.aop.domain;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class GreetingAfterAdvice implements AfterReturningAdvice {
	// 在目标类方法调用后执行
	public void afterReturning(Object returnOcj, Method method, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("============GreetingAfterAdvice.afterReturning()============");
		System.out.println("Please enjoy yourself! " + arg2[0]);
		System.out.println("============GreetingAfterAdvice.afterReturning()============");
		System.out.println();
	}

}
