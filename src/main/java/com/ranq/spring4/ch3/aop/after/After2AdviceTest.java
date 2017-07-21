package com.ranq.spring4.ch3.aop.after;

import org.junit.Test;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranq.spring4.ch3.aop.domain.GreetingAfterAdvice;
import com.ranq.spring4.ch3.aop.domain.IWaterBiz;
import com.ranq.spring4.ch3.aop.domain.NativeWaterBizImpl;

public class After2AdviceTest {
	private IWaterBiz		biz;
	private AfterAdvice		advice;
	private ProxyFactory	pf;

	/**
	 * 执行每个测试方法之前调用
	 */
	public void init() {
		biz = new NativeWaterBizImpl();
		advice = new GreetingAfterAdvice();
		//1.Spring 提供的代理工厂
		pf = new ProxyFactory();
		//2.设置代理目标
		pf.setTarget(biz);
		//3.为代理目标添加增强
		pf.addAdvice(advice);
	}

	@Test
	public void afterAdvice() {
		init();
		IWaterBiz proxy = (IWaterBiz) pf.getProxy();
		proxy.greetTo("John");
		proxy.serveTo("Tom");
	}

	@Test
	public void afterAdvice01() throws Exception {
		String configPath = "com/ranq/spring4/ch3/aop/after/applicationContext-after2.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

		IWaterBiz proxy = (IWaterBiz) ctx.getBean("waiter");
		proxy.greetTo("John");
		proxy.serveTo("Tom");
	}
}
