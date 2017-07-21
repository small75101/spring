package com.ranq.spring4.ch3.advice;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author dsir
 * @create 2017-07-19 11:26
 **/
public class LogAfterReturningAdvice implements AfterReturningAdvice{
    Logger logger = Logger.getLogger(getClass());
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        logger.info("结束审核数据...");
        logger.info(returnValue+" "+method+" "+args+" "+target);
    }
}
