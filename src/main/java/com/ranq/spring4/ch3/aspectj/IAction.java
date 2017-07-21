package com.ranq.spring4.ch3.aspectj;

import java.util.Date;

/**
 * @author dsir
 * @create 2017-07-20 14:04
 **/
public interface IAction {
    Object show(String name, Date date);

    Object show(String name);
}
