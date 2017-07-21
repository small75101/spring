package com.ranq.spring4.ch3.aop.aop1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * 	首先看经典的基于代理的AOP:
 * Spring支持五种类型的通知：
 * Before(前)  org.apringframework.aop.MethodBeforeAdvice
 * After-returning(返回后) org.springframework.aop.AfterReturningAdvice
 * After-throwing(抛出后) org.springframework.aop.ThrowsAdvice
 * Arround(周围) org.aopaliance.intercept.MethodInterceptor
 * Introduction(引入) org.springframework.aop.IntroductionInterceptor
 * </pre>
 * 
 */
public class Aop1 {
	@Test
	public void test01() throws Exception {

		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/ranq/spring4/ch3/aop/aop1/applicationContext-aop1-test01.xml");
		Sleepable sleeper = (Sleepable) appCtx.getBean("humanProxy");
		sleeper.sleep();
	}

	@Test
	public void test02() throws Exception {

		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/ranq/spring4/ch3/aop/aop1/applicationContext-aop1-test02.xml");
		Sleepable sleeper = (Sleepable) appCtx.getBean("human");
		sleeper.sleep();
	}
}
