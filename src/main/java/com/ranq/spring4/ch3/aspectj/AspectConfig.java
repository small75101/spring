package com.ranq.spring4.ch3.aspectj;

import org.springframework.context.annotation.*;

/**
 * @author dsir
 * @create 2017-07-20 14:20
 **/
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.ranq.spring4.ch3.aspectj")
public class AspectConfig {
    public AspectConfig() {
        System.out.println("AspectConfig.AspectConfig");
    }

    @Bean
    @Profile("dev")
    public Aspect01 aspect01(){
        System.out.println("AspectConfig.aspect01");
        return new Aspect01();
    }
}
