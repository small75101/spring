package com.ranq.spring4.ch2.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * DemoMain.class
 *
 * @author dsir
 * @create 2017-07-14 11:33
 **/
public class DemoMain {
    public static AnnotationConfigApplicationContext context = null;

    public static void main(String[] args) {
        context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        test(2);
        context.close();
    }

    public static void test2() {
        DemoService p2 = context.getBean(DemoService.class);
        System.out.println(p2);
    }

    public static void test1() {
        DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = context.getBean(DemoSingletonService.class);

        DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);

        System.out.println("s1 与 s2 是否相等:" + s1.equals(s2));
        System.out.println("p1 与 p2 是否相等:" + p1.equals(p2));
    }

    public static void test(int i) {
        try {
            Class<DemoMain> demoMainClass = DemoMain.class;
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

