package com.ranq.spring4.ch3.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

/**
 * @author dsir
 * @create 2017-07-19 11:18
 * <p>
 * Interceptor Around 通知
 **/
public class LogAroundInterceptor implements MethodInterceptor {
    Logger logger = Logger.getLogger(getClass());

    public Object invoke(MethodInvocation invocation) throws Throwable {
        logger.info("开始审核数据。。。。");
        Object rval = invocation.proceed();
        logger.info("审核结果：" + rval);
        logger.info("结束审核数据。。。。");
        return rval;
    }
}
