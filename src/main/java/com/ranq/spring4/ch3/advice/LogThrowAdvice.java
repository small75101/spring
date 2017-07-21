package com.ranq.spring4.ch3.advice;

import org.apache.ibatis.javassist.tools.rmi.RemoteException;
import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

/**
 * @author dsir
 * @create 2017-07-19 11:29
 **/
public class LogThrowAdvice implements ThrowsAdvice {
    Logger logger = Logger.getLogger(getClass());

    public void afterThrowing(RemoteException ex) throws  Throwable{
        logger.info("审核数据抛出异常，请检查。。"+ex);
    }
}
