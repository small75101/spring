package com.ranq.spring4.ch3.aop.before;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranq.spring4.ch3.aop.domain.DeptDao;
import com.ranq.spring4.ch3.aop.domain.UserDAOImpl;

public class Before1Test {
	/**
	 * 非接口
	 * 
	 * @throws Exception
	 */
	@Test
	public void test01() throws Exception {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/ranq/spring4/ch3/aop/before/applicationContext-before1.xml");
		UserDAOImpl dao = (UserDAOImpl) appCtx.getBean("userDAO");
		dao.save();
		dao.update();
	}

	/**
	 * 接口但是定义实现类
	 * 
	 * @throws Exception
	 */
	@Test
	public void test02() throws Exception {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/ranq/spring4/ch3/aop/before/applicationContext-before1.xml");
		DeptDao dao = (DeptDao) appCtx.getBean("deptDao");
		dao.save();
		dao.update();
	}
}
