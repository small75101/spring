package com.ranq.spring4.ch3.aspectj;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面定义
 *
 * @author dsir
 * @create 2017-07-20 14:02
 **/
@Aspect
public class Aspect01 {
    Logger logger = Logger.getLogger(getClass());
    @Pointcut("execution(* com.ranq.spring4.ch3.aspectj.IAction.show(..))")
    public void doActionShow() {
    }

    @Pointcut("execution(* com.ranq.spring4.ch3.aspectj.IAction.show(String)) && args(name)")
    public void doActionShowAndArgs(String name) {
    }

    @Before("doActionShowAndArgs(name)")
    public void doBefore(String name) {
       logger.info("=====Aspect01.doBefore====="+name);
    }

    @After("doActionShow()")
    public void doAfter() {
       logger.info("=====Aspect01.doAfter");
    }

    @AfterReturning("doActionShow()")
    public void doAfterReturning() {
       logger.info("=====Aspect01.doAfterReturning");
    }

    @AfterThrowing("doActionShow()")
    public void doAfterThrowing() {
       logger.info("=====Aspect01.doAfterThrowing");
    }

    @Around("doActionShow()")
    public void doAround(ProceedingJoinPoint jp) {
        try {
           logger.info("=====Aspect01.doAround:begin");
            Object proceed = jp.proceed();
           logger.info("结果:" + proceed);
        } catch (Throwable throwable) {
           logger.info("Throw Error" + throwable.getMessage());
        } finally {
           logger.info("=====Aspect01.doAround:end");
        }
    }
}
