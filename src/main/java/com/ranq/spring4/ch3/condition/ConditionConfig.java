package com.ranq.spring4.ch3.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author dsir
 * @create 2017-07-14 14:46
 **/
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowCondition.class)
    public ListService createWindowService() {
        return new WindowListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService createLinuxService() {
        return new LinuxListService();
    }
}
