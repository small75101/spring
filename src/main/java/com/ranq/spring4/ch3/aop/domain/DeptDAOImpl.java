package com.ranq.spring4.ch3.aop.domain;

import org.springframework.stereotype.Service;


@Service
public class DeptDAOImpl implements DeptDao {

	public void save() {
		System.out.println("DeptDAOImpl.save()");
	}

	public void update() {
		System.out.println("DeptDAOImpl.update()");
	}

}
