package com.ranq.spring4.ch3.aop.domain;

import org.aspectj.lang.JoinPoint;

/**
 * 安全 <bean id="security" class="com.rupeng.service.Security" />
 */
public class Security {
	public void checkSecurity(JoinPoint point) {
		System.out.println("point.getTarget()  " + point.getTarget());
		System.out.println("point.getSignature().getName()" + point.getSignature().getName());
	}
}
