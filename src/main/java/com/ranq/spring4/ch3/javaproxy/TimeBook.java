package com.ranq.spring4.ch3.javaproxy;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author dsir
 * @create 2017-07-19 10:15
 **/
public class TimeBook implements TimeBookInterface {
    Logger logger = Logger.getLogger(TimeBook.class);

    public String doAuditing(String name) {
        //审核数据的相关程序
        logger.log(Level.INFO,"审核数据的相关程序");
        return "审核的数据:"+name;
    }
}
