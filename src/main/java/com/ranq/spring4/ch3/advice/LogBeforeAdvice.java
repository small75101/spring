package com.ranq.spring4.ch3.advice;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Before通知
 *
 * @author dsir
 * @create 2017-07-19 11:23
 **/
public class LogBeforeAdvice implements MethodBeforeAdvice {
    Logger logger = Logger.getLogger(getClass());

    public void before(Method method, Object[] args, Object target) throws Throwable {
        logger.info("开始审核数据...");
        logger.info(method + " " + args + " " + target);
    }
}
