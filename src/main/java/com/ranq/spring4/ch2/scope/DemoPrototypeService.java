package com.ranq.spring4.ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * DemoPrototypeService
 *
 * @author dsir
 * @create 2017-07-14 11:42
 **/
@Service
@Scope("prototype")
public class DemoPrototypeService {
}
