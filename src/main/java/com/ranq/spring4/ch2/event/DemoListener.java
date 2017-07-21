package com.ranq.spring4.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * DemoListener
 *
 * @author dsir
 * @create 2017-07-14 13:47
 **/
@Component
public class DemoListener implements ApplicationListener<DemoEvent>{

    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("我（bean-demoListener）接收到了bean-dempPublisher发布的信息:"+msg);
    }
}
