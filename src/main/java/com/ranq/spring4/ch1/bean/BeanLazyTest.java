package com.ranq.spring4.ch1.bean;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.LazyLoader;

/**
 * @author dsir
 * @create 2017-07-19 14:16
 **/
public class BeanLazyTest    {
    public static void main(String[] args) {
        // 创建Bean类型的延迟加载代理实例
        TestBean bean = (TestBean) Enhancer.create(TestBean.class, new LazyProxy());
        System.out.println("------");
        System.out.println(bean.getUserName());
    }
}
/**
 * 对象懒加载
 *
 * @author Administrator
 *
 */
class TestBean {
    private String userName;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}

// 延迟加载代理类
class LazyProxy implements LazyLoader {

    // 拦截Bean的加载，本方法会延迟处理
    public Object loadObject() throws Exception {
        System.out.println("开始延迟加载!");
        TestBean bean = new TestBean(); // 创建实体Bean
        bean.setUserName("test"); // 给一个属性赋值
        return bean; // 返回Bean
    }
}

