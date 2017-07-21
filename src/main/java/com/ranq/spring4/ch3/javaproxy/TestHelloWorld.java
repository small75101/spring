package com.ranq.spring4.ch3.javaproxy;

/**
 * @author dsir
 * @create 2017-07-19 10:16
 **/
public class TestHelloWorld {
    public static void main(String[] args) {
        ProxyUtil logProxy = new ProxyUtil(new TimeBook());
        TimeBookInterface tb = logProxy.getProxyObject(TimeBookInterface.class);
        tb.doAuditing("张三");
    }
}
