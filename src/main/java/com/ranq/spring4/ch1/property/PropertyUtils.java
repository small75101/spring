package com.ranq.spring4.ch1.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyUtils {
	//属性文件的路径
	private String		profilepath	= "db.properties";

	/**
	 * 采用静态方法
	 */
	private Properties	props		= new Properties();

	private String		comments	= "DatabaseLink  last times of update:";

	public PropertyUtils() {
		try {
			init();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PropertyUtils(String profilepath) {
		try {
			this.profilepath = profilepath;
			init();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载文件到Properties
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void init() throws FileNotFoundException, IOException {
		File f = new File(profilepath);
		if (f.getParent() != null && !f.getParentFile().exists())
			f.getParentFile().mkdirs();
		if (!f.exists())
			f.createNewFile();
		props.load(new FileInputStream(f));
	}

	/**
	 * 读取属性文件中相应键的值
	 * 
	 * @param key
	 *            主键
	 * @return String
	 */
	public String getProperty(String key) {
		return props.getProperty(key);
	}

	/**
	 * 更新（或插入）一对properties信息(主键及其键值) 如果该主键已经存在，更新该主键的值； 如果该主键不存在，则插件一对键值。
	 * 
	 * @param keyname
	 *            键名
	 * @param keyvalue
	 *            键值
	 */
	public void addProperty(String keyname, String keyvalue) {
		try {
			// 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
			// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
			OutputStream os = new FileOutputStream(profilepath);
			props.setProperty(keyname, keyvalue);
			// 以适合使用 load 方法加载到 Properties 表中的格式，
			// 将此 Properties 表中的属性列表（键和元素对）写入输出流
			props.store(os, comments);
		} catch (IOException e) {
			System.err.println("属性文件更新错误");
		}
	}

	public void removeProperty(String keyname) {
		try {
			// 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
			// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
			OutputStream fos = new FileOutputStream(profilepath);
			props.remove(keyname);
			// 以适合使用 load 方法加载到 Properties 表中的格式，
			// 将此 Properties 表中的属性列表（键和元素对）写入输出流
			props.store(fos, comments);
		} catch (IOException e) {
			System.err.println("属性文件更新错误");
		}
	}
}
