package com.ranq.spring4.ch3.aop.aspect;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ranq.spring4.ch3.aop.domain.IWaterBiz;

/**
 * <pre>
 * Schema配置切面
 * <aop:aspect>元素标签定义切面，其内部定义多个增强
 * <aop:config>元素可以定义多个切面
 * 
 * 
 * 	<!-- 配置命名切点 -->
 * 	<!-- 使用<aop:pointcut>定义一个切点 id命名 切面中使用pointcut-ref引用 这样与 <aop:before>一样 -->
 * 	<!-- 除引介增强以外，其他任何增强都拥有3个属性 pointcut,pointcut-ref,method -->
 * 	<!-- 切点如果定义在<aop:aspect>元素中 则命名切点只能被当前<aop:aspect>内定义的元素访问，注意顺序 -->
 * 	<!-- 切点如果定义在<aop:config>元素中 则命名切点能被整个该<aop:config>内定义的元素访问，注意顺序 -->
 * 	<!-- 切点配置例子： <aop:pointcut id="greetToPointcut" expression="target(com.ranq.spring4.ch3.aop.domain.NativeWaterBizImpl) and execution(* greetTo(..))"/> -->
 * 
 * 
 * 	<!-- 后置增强配置 -->
 * 	<!--<aop:after-returning method="afterReturning" pointcut="target(com.ranq.spring4.ch3.aop.domain.NativeWaterBizImpl)" returning="retVal"/> -->
 * 	<!-- returning属性必须和增强方法入参名一直 可选 -->
 * 
 *  <!-- 环绕增强配置 -->
 *  <!--<aop:around method="aroundMethod" pointcut="target(com.ranq.spring4.ch3.aop.domain.NativeWaterBizImpl)"/> -->
 *  <!--对应的方法可以将第一个入参声明为ProceedingJoinPoint pjp可以访问到环绕增强的连接点信息 -->
 *  	
 *  <!-- 抛出异常增强配置 -->
 * 	<!--<aop:after-throwing method="afterThrowingMethod" pointcut="target(com.ranq.spring4.ch3.aop.domain.NativeWaterBizImpl)" throwing="iae"/> -->
 * 	<!--iae 通过iae查找增强方法对应名称的入参，进而获取需要增强的连接点的匹配异常类型为IllegalArgumentExeception -->
 * 	<!-- 通过throwing属性声明需要绑定的异常对象，指定的异常名必须和增强方法对应的入参名一直 -->
 * 
 * 	<!-- Final增强配置 -->
 * 	<!--<aop:after method="afterMethod" pointcut="execution(* com..*.Waiter.greetTo(..))"/> -->
 * 	<!--iae 通过iae查找增强方法对应名称的入参，进而获取需要增强的连接点的匹配异常类型为IllegalArgumentExeception -->
 * 	<!-- 通过throwing属性声明需要绑定的异常对象，指定的异常名必须和增强方法对应的入参名一直 -->
 * 	
 * 	<!-- 引介增强配置 -->
 * 
 *  <!-- 绑定连接点 -->
 *  切点表达式中通过args(name,num,..)绑定了连接点的两个参数，对应的增强函数
 *  <aop:before method="bindParams" pointcut="tatget(com.smart,NaiveWaiter) and args(name,num,..)"/>
 *  public void bindParams(ing num,String name)
 * </pre>
 * 
 */
public class Aspect2Test {
	/**
	 * 配置文件
	 * 
	 * @throws Exception
	 */
	@Test
	public void testProxy02() throws Exception {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/ranq/spring4/ch3/aop/aspect/applicationContext-aspect2.xml");
		IWaterBiz proxy = (IWaterBiz) appCtx.getBean("nativeWaterBizImpl");

		proxy.greetTo("John");
		proxy.serveTo("Tom");
	}
}
