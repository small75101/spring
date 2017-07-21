package com.ranq.spring4.ch3.aop.aop1;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SleepHelper implements MethodBeforeAdvice, AfterReturningAdvice {

	public void before(Method mtd, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("通常情况下睡觉之前要脱衣服！");
	}

	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("起床后要先穿衣服！");
	}

}
