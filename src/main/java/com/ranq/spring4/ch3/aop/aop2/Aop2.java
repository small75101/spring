package com.ranq.spring4.ch3.aop.aop2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranq.spring4.ch3.aop.aop1.Sleepable;

/**
 * 配置文件
 * 
 * AspectJ配置
 * 
 * @author Administrator
 * 
 */
public class Aop2 {
	@Test
	public void test01() throws Exception {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/ranq/spring4/ch3/aop/aop2/applicationContext-aop3.xml");
		Sleepable human = (Sleepable) appCtx.getBean("human");
		human.sleep();
	}
}
