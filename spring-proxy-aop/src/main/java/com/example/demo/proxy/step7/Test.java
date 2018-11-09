package com.example.demo.proxy.step7;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Test { // 클라이언트
	@Autowired
	private Hello h;
	
	public void order() {
		h.say();
	}

	public static void main(String[] args) {
//		Hello hello = new Hello();
//		hello.say();
//		
//		System.out.println();
//		
//		Advice advice = new MyAdvice();
//		
//		ProxyFactory factory = new ProxyFactory();
//		factory.setTarget(hello);
//		factory.addAdvice(advice);
//		
//		Hello proxy = (Hello) factory.getProxy();
//		proxy.say();
		
		/*
		 * 코드적으로 개발자가 객체생성, 관계설정을 하지 않고
		 * 빈 환경설정을 통해서 스프링에게 위임해 보자. 
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"proxy-factory-bean-demo.xml");
		
		Hello proxy = (Hello) context.getBean("proxy");
		proxy.say();
		
	}

}
