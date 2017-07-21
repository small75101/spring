package com.ranq.spring4.ch3.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceMethods {
	/**
	 * 前置增强
	 */
	public void preGreeting() {
		System.out.println("-- How are you! --");
	}

	/**
	 * 后置增强
	 * 
	 * @param retVal
	 */
	public void afterReturning(int retVal) {

	}

	/**
	 * 环绕增强
	 * 
	 * @param pjp
	 */
	public void aroundMethod(ProceedingJoinPoint pjp) {

	}

	/**
	 * 抛出异常增强
	 * 
	 * @param iae
	 */
	public void afterThrowingMethod(IllegalArgumentException iae) {

	}

	/**
	 * Final增强
	 */
	public void afterMethod() {

	}
}
