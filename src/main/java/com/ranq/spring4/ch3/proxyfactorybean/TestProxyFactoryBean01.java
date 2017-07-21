package com.ranq.spring4.ch3.proxyfactorybean;

import com.ranq.spring4.ch3.javaproxy.TimeBookInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author dsir
 * @create 2017-07-19 13:44
 **/
public class TestProxyFactoryBean01 {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:com/ranq/spring4/ch3/proxyfactorybean/proxyfactorybean02.xml");
        TimeBookInterface dao = (TimeBookInterface) context.getBean("logProxy");
        dao.doAuditing("张三");
    }

}
