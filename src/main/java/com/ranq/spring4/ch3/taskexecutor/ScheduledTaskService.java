package com.ranq.spring4.ch3.taskexecutor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dsir
 * @create 2017-07-14 14:31
 **/
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔五秒执行一次"+DATE_FORMAT.format(new Date()));
    }
    @Scheduled(cron = "0 38 14 ? * *")
    public void fixTimeExection(){
        System.out.println("在指定时间:"+DATE_FORMAT.format(new Date())+"执行");
    }
}
