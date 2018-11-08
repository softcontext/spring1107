package com.example.demo.ioc.step7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		CarMaker maker = new KiaMaker(); // 객체생성
//		CarMaker maker = new HyundaiMaker(); // 객체생성
//		
//		OrderManager manager = new OrderManager(); // 객체생성
//		manager.setMaker(maker); // 관계설정
//		manager.order(); // 로직호출

		/*
		 * 스프링에게 객체생성, 관계설정을 위임하는 방법 3가지
		 * 1. XML : 스프링 버전 2에서 도입
		 * 2. Annotation : 스프링 버전 3에서 도입
		 * 3. Java Configuration Class : 부트에서 주로 사용
		 */
		
		ApplicationContext context = new AnnotationConfigApplicationContext(
				CarConfig.class);
		
		OrderManager manager = (OrderManager) context.getBean("manager");
		manager.order();
	}

}
