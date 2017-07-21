package com.ranq.spring4.ch3.aop.after;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranq.spring4.ch3.aop.domain.UserDAOImpl;

public class After1AdviceTest {
	/**
	 * 非接口
	 * 
	 * @throws Exception
	 */
	@Test
	public void test01() throws Exception {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/ranq/spring4/ch3/aop/after/applicationContext-after1.xml");
		UserDAOImpl dao = (UserDAOImpl) appCtx.getBean("userDAO");
		dao.save();
		dao.update();
	}
}
