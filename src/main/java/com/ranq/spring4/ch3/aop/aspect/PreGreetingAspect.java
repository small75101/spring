package com.ranq.spring4.ch3.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * <pre>
 * @Aspect 几个增强注解
 * 
 * @Before
 * 	前置增强
 * @AfterReturning
 *  后置增强
 * @Around
 * 	环绕增强
 * @AfterThrowing
 *  抛出增强
 * @After
 * 	Final增强，不管是抛出异常还是正常退出都会执行
 * @DeclareOarents
 *  引介增强
 * </pre>
 * 
 */
@Aspect
public class PreGreetingAspect {
	//定义切点与增强类型 @Before("execution(* greetTo(..))")
	//增强的横切逻辑 beforeGreeting()
	@Before("execution(* greetTo(..))")
	public void beforeGreeting() {
		System.out.println("How are you");
	}
}
