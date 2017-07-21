package com.ranq.spring4.ch2.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ScopeConfig.class
 *
 * @author dsir
 * @create 2017-07-14 11:25
 **/
@Configuration
@ComponentScan("com.ranq.spring4.ch2.scope")
public class ScopeConfig {
    public ScopeConfig(){
        System.out.println("ScopeConfig.ScopeConfig");
    }
    @Bean
    public DemoService createDemoService(){
        System.out.println("ScopeConfig.createDemoService");
        return new DemoService();
    }
}
