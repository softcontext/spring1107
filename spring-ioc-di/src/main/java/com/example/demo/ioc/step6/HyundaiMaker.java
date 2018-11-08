package com.example.demo.ioc.step6;

import org.springframework.stereotype.Component;

// <bean id="hyundaiMaker" class="com.example.demo.ioc.step6.HyundaiMaker"></bean>
@Component("hyundaiMaker")
public class HyundaiMaker implements CarMaker {
	
	@Override
	public Car sell(Money money) {
		System.out.println("HyundaiMaker: sell(Money money) called.");
		
		System.out.println(
				"HyundaiMaker: " + money.getAmount() + "원을 차 값으로 받는다.");
		
		Car car = new Car("Sonata");
		System.out.println(
				"HyundaiMaker: " + car.getName() + "를 만들어 판다.");
		
		return car;
	}
	
}
