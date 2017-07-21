package com.ranq.spring4.ch3.aop.domain;

public class UserDAOImpl {
	public Integer save() {
		System.out.println("UserDAOImpl.save()");
		return 1;
	}

	public void update() {
		System.out.println("UserDAOImpl.update()");
	}
}
