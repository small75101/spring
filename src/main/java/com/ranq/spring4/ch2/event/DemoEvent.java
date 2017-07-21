package com.ranq.spring4.ch2.event;

import org.springframework.context.ApplicationEvent;

/**
 * DemoEvent
 *
 * @author dsir
 * @create 2017-07-14 13:44
 **/
public class DemoEvent extends ApplicationEvent{
    private static final long serialVersionUID = 1L;
    private String msg;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


