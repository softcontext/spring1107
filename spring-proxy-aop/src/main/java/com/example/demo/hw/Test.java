package com.example.demo.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"car-advice.xml");
		
		/*
		 * 1. XML로 설정
		 * 2. Annotation으로 설정
		 * 
		 * SafetyBeltCheckAdvice 클래스 안에 어드바이스 로직을 완성하고
		 * 빈 환경설정 #1, #2 방법으로 아래 코드가 제대로 작동하도록
		 * AOP 설정을 해서 제출합니다.
		 */
		
		// 일반 차는 안전벨트 체크 기능이 없습니다. 즉, 어드바이스를 적용하지 않습니다.
		Car car = context.getBean("car", Car.class);
		car.start();
		car.stop();
		
		// 고급 차는 안전벨트 체크 기능이 있습니다. 즉, 어드바이스를 적용하세요.
		Car luxuryCar = context.getBean("luxuryCar", Car.class);
		// 안전 벨트를 착용했으면 "Engine is running..."
		// 안전 벨트를 착용하지 않았으면 "딩동~! 딩동! 안전벨트를 착용하세요!"
		luxuryCar.start();
		luxuryCar.start();
		luxuryCar.start();
		
		luxuryCar.stop();
	}

}
