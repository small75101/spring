package com.ranq.spring4.ch3.taskexecutor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author dsir
 * @create 2017-07-14 14:35
 **/
@Configuration
@ComponentScan("com.ranq.spring4.ch3.taskexecutor")
@EnableScheduling
public class TaskSchedulerConfig {
}
