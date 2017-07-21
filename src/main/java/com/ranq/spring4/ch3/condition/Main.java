package com.ranq.spring4.ch3.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dsir
 * @create 2017-07-14 14:49
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        System.out.println("====================================");
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name")+"系统下的列表命令:");
        listService.showListCmd();
    }
}
