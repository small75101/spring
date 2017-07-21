package com.ranq.spring4.ch3.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGProxy implements MethodInterceptor {
	//要代理的原始对象  
	private Object	obj;

	public Object createProxy(Object target) {
		this.obj = target;
		Enhancer enhancer = new Enhancer();
		// 设置要代理的目标类，以扩展它的功能  
		enhancer.setSuperclass(this.obj.getClass());
		// 设置单一回调对象，在回调中拦截对目标方法的调用  
		enhancer.setCallback(this);
		//设置类装载器  
		enhancer.setClassLoader(target.getClass().getClassLoader());
		//创建代理对象  
		return enhancer.create();
	}



	private void doBefore() {
		System.out.println("before method invoke");
	}

	private void doAfter() {
		System.out.println("after method invoke");
	}

	/**
	 * 回调方法:在代理实例上拦截并处理目标方法的调用，返回结果
	 *
	 * @param proxy
	 *            代理类
	 * @param method
	 *            被代理的方法
	 * @param params
	 *            该方法的参数数组
	 * @param methodProxy
	 */
	public Object intercept(Object proxy, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
		Object result = null;
		// 调用之前
		doBefore();
		// 调用目标方法，用methodProxy,
		// 而不是原始的method，以提高性能
		result = methodProxy.invokeSuper(proxy, params);
		// 调用之后
		doAfter();
		return result;
	}
}
