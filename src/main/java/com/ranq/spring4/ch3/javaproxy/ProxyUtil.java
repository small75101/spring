package com.ranq.spring4.ch3.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @title 代理中间类：
 * 
 */
public class ProxyUtil implements InvocationHandler {
	private Object	target; // 被代理的对象

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("do sth before....");
		Object result = method.invoke(target, args);
		System.out.println("do sth after....");
		return result;
	}

	ProxyUtil(Object target) {
		this.target = target;
	}

	@SuppressWarnings("unchecked")
	public <T> T getProxyObject(Class<T> clazz) {
		return (T) Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
	}

	public Object getProxyObject() {
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
	}
}