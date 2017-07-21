package com.ranq.spring4.ch1.property;

import org.junit.Test;

public class PropertUtilsTest {
	@Test
	public void test() throws Exception {
		PropertyUtils prop = new PropertyUtils();
		System.out.println(prop);
		prop.addProperty("aa1", "1");
		prop.addProperty("bbb", "22");
		prop.addProperty("ss", "22");
		System.out.println(prop.getProperty("aa1"));
	}

	@Test
	public void test01() throws Exception {
		//取得根目录路径  
		String rootPath = getClass().getResource("/").getFile().toString();
		//当前目录路径  
		String currentPath1 = getClass().getResource(".").getFile().toString();
		String currentPath2 = getClass().getResource("").getFile().toString();
		//当前目录的上级目录路径  
		String parentPath = getClass().getResource("../").getFile().toString();
		System.out.println(rootPath);
		System.out.println(currentPath1);
		System.out.println(currentPath2);
		System.out.println(parentPath);
	}
}
