package com.ranq.spring4.ch3.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author dsir
 * @create 2017-07-20 10:19
 **/
public class CGProxyUtil implements MethodInterceptor {
    //要代理的原始对象
    private Object obj;
    private BeforeMethod beforeMethod;
    private AfterMethod afterMethod;

    public Object createProxy(Object target, BeforeMethod beforeMethod, AfterMethod afterMethod) {
        this.obj = target;
        this.beforeMethod = beforeMethod;
        this.afterMethod = afterMethod;

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

    public interface BeforeMethod {
        Object doBefore(Object obj, Method method, Object[] args);
    }

    public interface AfterMethod {
        Object doAfter(Object obj, Method method, Object[] args, Object result);
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = null;
        // 调用之前
        beforeMethod.doBefore(obj, method, args);
        // 调用目标方法，用methodProxy,
        // 而不是原始的method，以提高性能
        result = proxy.invokeSuper(obj, args);
        // 调用之后
        afterMethod.doAfter(obj, method, args, result);
        return result;
    }
}
