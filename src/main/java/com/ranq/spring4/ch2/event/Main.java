package com.ranq.spring4.ch2.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dsir
 * @create 2017-07-14 13:52
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class
        );
        DemoPublicher demoPublicher = context.getBean(DemoPublicher.class);
        demoPublicher.publish("hello application event ");

        context.close();
    }
}
