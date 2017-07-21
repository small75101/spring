package com.ranq.spring4.ch3.aspectj;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dsir
 * @create 2017-07-20 14:21
 **/
@Service
public class ActionImpl implements IAction {
    Logger logger = Logger.getLogger(getClass());
    public Object show(String name, Date date) {
        logger.info("ActionImpl.show");
        logger.info("欢迎:"+name+"  签到时间:"+date);
        Map<String,Object> re = new HashMap<String,Object>();
        re.put("name",name);
        re.put("date",date);
        return re;
    }
    public Object show(String name) {
        logger.info("ActionImpl.show");
        logger.info("欢迎:"+name);
        Map<String,Object> re = new HashMap<String,Object>();
        re.put("name",name);
        return re;
    }
}
