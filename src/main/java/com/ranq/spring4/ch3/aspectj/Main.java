package com.ranq.spring4.ch3.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author dsir
 * @create 2017-07-20 14:24
 **/
public class Main {
    public static void main(String[] args) {
        test(1);
    }

    public static void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(AspectConfig.class);
        context.refresh();

        IAction action = context.getBean(IAction.class);
        action.show("张三");
    }
    public static void test2() {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:com/ranq/spring4/ch3/aspectj/aspectj01.xml");
        IAction action = context.getBean(IAction.class);
        action.show("张三", new Date());
    }

    public static void test(int i) {
        try {
            Class<Main> demoMainClass = Main.class;
            Method[] methods = demoMainClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().replace("test", "").equals(String.valueOf(i))) {
                    method.invoke(null);
                    break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
