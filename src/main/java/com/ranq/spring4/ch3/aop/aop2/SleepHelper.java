package com.ranq.spring4.ch3.aop.aop2;

import org.aspectj.lang.annotation.Aspect;
/**
 * 使用AspectJ提供的注解
 * @author Administrator
 *
 */
@Aspect
public class SleepHelper {

	public SleepHelper() {

	}

	public void sleeppoint() {}

	public void beforeSleep() {
		System.out.println("睡觉前要脱衣服!");
	}

	public void afterSleep() {
		System.out.println("睡醒了要穿衣服！");
	}

}