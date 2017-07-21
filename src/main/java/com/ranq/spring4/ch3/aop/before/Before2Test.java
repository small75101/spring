package com.ranq.spring4.ch3.aop.before;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranq.spring4.ch3.aop.domain.GreetingBeforeAdvice;
import com.ranq.spring4.ch3.aop.domain.IWaterBiz;
import com.ranq.spring4.ch3.aop.domain.NativeWaterBizImpl;

public class Before2Test {
	private IWaterBiz		biz;
	private BeforeAdvice	advice;
	private ProxyFactory	pf;

	/**
	 * 执行每个测试方法之前调用
	 */
	public void init() {
		biz = new NativeWaterBizImpl();
		advice = new GreetingBeforeAdvice();
		//1.Spring 提供的代理工厂
		pf = new ProxyFactory();
		//2.设置代理目标
		pf.setTarget(biz);
		//3.为代理目标添加增强
		pf.addAdvice(advice);
	}

	@Test
	public void beforeAdvice() {
		init();
		IWaterBiz proxy = (IWaterBiz) pf.getProxy();
		proxy.greetTo("John");
		proxy.serveTo("Tom");
	}

	@Test
	public void beforeAdvice01() throws Exception {
		String configPath = "com/ranq/spring4/ch3/aop/before/applicationContext-before2.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

		IWaterBiz proxy = (IWaterBiz) ctx.getBean("waiter");
		proxy.greetTo("John");
		proxy.serveTo("Tom");
	}
}
