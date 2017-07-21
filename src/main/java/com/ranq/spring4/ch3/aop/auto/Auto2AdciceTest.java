package com.ranq.spring4.ch3.aop.auto;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranq.spring4.ch3.aop.domain.IWaterBiz;
import com.ranq.spring4.ch3.aop.domain.NativeWaterBizImpl;

/**
 * 自动创建代理 2扫描容器中Advisor（包含横切，连接点）
 * 
 * 失败
 * 
 * @title org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator Bean对象代理
 */
public class Auto2AdciceTest {
	@Test
	public void test() throws Exception {
		String configPath = "com/ranq/spring4/ch3/aop/auto/applicationContext-auto2.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

		IWaterBiz proxy = (NativeWaterBizImpl) ctx.getBean("nativeWaterBizImpl");
		proxy.greetTo("John");
		proxy.serveTo("Tom");
	}
}
