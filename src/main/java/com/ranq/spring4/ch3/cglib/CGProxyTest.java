package com.ranq.spring4.ch3.cglib;

import com.ranq.spring4.ch3.javaproxy.TimeBook;
import com.ranq.spring4.ch3.javaproxy.TimeBookInterface;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 可以使用接口 与类
 *
 * @author Administrator
 */
public class CGProxyTest {
    /**
     * 实现接口
     *
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        TimeBookInterface proxyedObject = new TimeBook(); // 被代理的对象
        CGProxy cgProxy = new CGProxy();
        TimeBookInterface proxyObject = (TimeBookInterface) cgProxy.createProxy(proxyedObject);
        proxyObject.doAuditing("张三");
    }

    /**
     * 未实现接口
     *
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        TimeBook proxyedObject = new TimeBook(); // 被代理的对象
        CGProxy cgProxy = new CGProxy();
        TimeBook proxyObject = (TimeBook) cgProxy.createProxy(proxyedObject);
        proxyObject.doAuditing("张三");
    }

    private CGProxyUtil.BeforeMethod beforeMethod;
    private CGProxyUtil.AfterMethod afterMethod;

    /**
     * 实现接口
     *
     * @throws Exception
     */
    @Test
    public void test03() throws Exception {
        beforeMethod = new CGProxyUtil.BeforeMethod(){
            public Object doBefore(Object obj, Method method, Object[] args) {
                System.out.print("提前通知:");
                System.out.println("method = [" + method + "], args = [" + args + "]");
                return null;
            }
        };
        afterMethod = new CGProxyUtil.AfterMethod() {
            public Object doAfter(Object obj, Method method, Object[] args, Object result) {
                System.out.print("后置通知:");
                System.out.println(" method = [" + method + "], args = [" + args + "], result = [" + result + "]");
                return null;
            }
        };


        TimeBookInterface proxyedObject = new TimeBook(); // 被代理的对象
        CGProxyUtil cgProxy = new CGProxyUtil();
        TimeBookInterface proxyObject = (TimeBookInterface) cgProxy.createProxy(proxyedObject, beforeMethod, afterMethod);
        proxyObject.doAuditing("张三");
    }

    /**
     * 未实现接口
     *
     * @throws Exception
     */
    @Test
    public void test04() throws Exception {
        beforeMethod = new CGProxyUtil.BeforeMethod(){
            public Object doBefore(Object obj, Method method, Object[] args) {
                System.out.println("提前通知");
                System.out.println("method = [" + method + "], args = [" + args + "]");
                return null;
            }
        };
        afterMethod = new CGProxyUtil.AfterMethod() {
            public Object doAfter(Object obj, Method method, Object[] args, Object result) {
                System.out.println("后置通知");
                System.out.println(" method = [" + method + "], args = [" + args + "], result = [" + result + "]");
                return null;
            }
        };

        TimeBook proxyedObject = new TimeBook(); // 被代理的对象
        CGProxyUtil cgProxy = new CGProxyUtil();
        TimeBook proxyObject = (TimeBook) cgProxy.createProxy(proxyedObject, beforeMethod, afterMethod);
        proxyObject.doAuditing("张三");
    }
}