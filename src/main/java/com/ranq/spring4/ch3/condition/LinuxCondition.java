package com.ranq.spring4.ch3.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author dsir
 * @create 2017-07-14 14:43
 **/

public class LinuxCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println("LinuxCondition.matches");
        return context.getEnvironment().getProperty("os.name").contains("Linux");
    }
}
