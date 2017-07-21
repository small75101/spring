package com.ranq.spring4.ch3.aop.aspect;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranq.spring4.ch3.aop.domain.IWaterBiz;
import com.ranq.spring4.ch3.aop.domain.NativeWaterBizImpl;

/**
 * <pre>
 * Administrator 基于AspectJ配置切面
 * AdpectJ 5的切点表达式 关键字和操作参数 如 execution(* greetTo(..))切点表达式
 * execution()称作函数 匹配串"* greetTo(..)"函数入参
 * 
 * 分类
 * 1.方法切点函数
 * 2.方法入参切点函数
 * 3.目标类切点函数
 * 4.代理类切点函数
 * 
 * 通配符
 * 1、 * ：任意字符，只能匹配上下文中一个元素
 * 2、 ..：任意字符，可以匹配上下文中的多个元素，但在表达类时，必须和*联合使用；在表示入参时则单独使用
 * 3、 + : 按类型匹配指定类的所有类，必须跟在类名后面，如com.smart.Car+,继承或扩展指定类的所有类，同时包括类本身
 * </pre>
 * 
 */
public class Aspect1Test {
	/**
	 * 工厂实现使用
	 * 
	 * @throws Exception
	 */
	@Test
	public void testProxy() throws Exception {
		IWaterBiz biz = new NativeWaterBizImpl();
		AspectJProxyFactory factory = new AspectJProxyFactory();
		//设置目标对象
		factory.setTarget(biz);
		//添加切面类
		factory.addAspect(PreGreetingAspect.class);
		//生成织入切面的代理对象
		IWaterBiz proxy = factory.getProxy();

		proxy.greetTo("John");
		proxy.serveTo("Tom");
	}

	/**
	 * 配置文件
	 * 
	 * @throws Exception
	 */
	@Test
	public void testProxy02() throws Exception {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/ranq/spring4/ch3/aop/aspect/applicationContext-aspect1.xml");
		IWaterBiz proxy = (IWaterBiz) appCtx.getBean("nativeWaterBizImpl");

		proxy.greetTo("John");
		proxy.serveTo("Tom");
	}
}
