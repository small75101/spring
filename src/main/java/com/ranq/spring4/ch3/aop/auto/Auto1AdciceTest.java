package com.ranq.spring4.ch3.aop.auto;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranq.spring4.ch3.aop.domain.IWaterBiz;
import com.ranq.spring4.ch3.aop.domain.NativeWaterBizImpl;

/**
 * 自动创建代理 1 Bean对象代理
 * 
 * @title org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator
 */
public class Auto1AdciceTest {
	@Test
	public void test() throws Exception {
		String configPath = "com/ranq/spring4/ch3/aop/auto/applicationContext-auto1.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

		IWaterBiz proxy = (NativeWaterBizImpl) ctx.getBean("nativeWaterBizImpl");
		proxy.greetTo("John");
		proxy.serveTo("Tom");
	}
}
