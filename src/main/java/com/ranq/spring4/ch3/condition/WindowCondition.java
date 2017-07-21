package com.ranq.spring4.ch3.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author dsir
 * @create 2017-07-14 14:42
 **/
public class WindowCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println("WindowCondition.matches");
        return context.getEnvironment().getProperty("os.name").contains("Windows");
    }
}
