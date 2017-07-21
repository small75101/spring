package com.ranq.spring4.ch1.bean;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 动态实体bean
 * 
 * @author cuiran
 * @version 1.0
 */
@SuppressWarnings("all")
public class BeanCreateTest {
	public static void main(String[] args) throws ClassNotFoundException { // 设置类成员属性
		HashMap<String, Class> propertyMap = new HashMap<String, Class>();
		propertyMap.put("id", Class.forName("java.lang.Integer"));
		propertyMap.put("name", Class.forName("java.lang.String"));
		propertyMap.put("address", Class.forName("java.lang.String")); // 生成动态Bean
		BeanCreateTest bean = new BeanCreateTest(propertyMap);
		// 给Bean设置值
		bean.setValue("id", 123); //Auto-boxing
		bean.setValue("name", "454");
		bean.setValue("address", "789");
		// 从Bean中获取值，当然获得值的类型是Object
		System.out.println(" >> id = " + bean.getValue("id"));
		System.out.println(" >> name = " + bean.getValue("name"));
		System.out.println(" >> address = " + bean.getValue("address"));
		// 获得bean的实体
		Object object = bean.getObject();
		// 通过反射查看所有方法名
		Class clazz = object.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method curMethod : methods) {
			System.out.println(curMethod.getName());
		}
	}

	//Bean实体Object
	public Object	object	= null;
	//属性map
	public BeanMap	beanMap	= null;

	public BeanCreateTest() {
		super();
	}

	public BeanCreateTest(Map<String, Class> propertyMap) {
		//用一组属性生成实体Bean
		this.object = generateBean(propertyMap);
		//用实体Bean创建BeanMap，以便可以设置和获取Bean属性的值
		this.beanMap = BeanMap.create(this.object);
	}

	/**
	 * 给bean中的属性赋值
	 * 
	 * @param property
	 *            属性名
	 * @param value
	 *            值
	 */
	public void setValue(String property, Object value) {
		beanMap.put(property, value);
	}

	/**
	 * 获取bean中属性的值
	 * 
	 * @param property
	 *            属性名
	 * @return 值
	 */
	public Object getValue(String property) {
		return beanMap.get(property);
	}

	/**
	 * 得到该实体bean对象
	 * 
	 * @return
	 */
	public Object getObject() {
		return this.object;
	}

	@SuppressWarnings("unchecked")
	private Object generateBean(Map<String, Class> propertyMap) {
		//根据一组属性名和属性值的类型，动态创建Bean对象
		BeanGenerator generator = new BeanGenerator();
		Set keySet = propertyMap.keySet();
		for (Iterator i = keySet.iterator(); i.hasNext();) {
			String key = (String) i.next();
			generator.addProperty(key, (Class) propertyMap.get(key));
		}
		return generator.create(); //创建Bean
	}
}
