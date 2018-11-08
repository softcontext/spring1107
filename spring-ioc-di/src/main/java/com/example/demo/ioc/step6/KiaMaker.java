package com.example.demo.ioc.step6;

import org.springframework.stereotype.Component;

@Component // id를 생략하면 클래스명을 id로 사용한다. 단, id는 소문자로 시작된다.
public class KiaMaker implements CarMaker {
	
	@Override
	public Car sell(Money money) {
		System.out.println("KiaMaker: sell(Money money) called.");
		
		System.out.println(
				"KiaMaker: " + money.getAmount() + "원을 차 값으로 받는다.");
		
		Car car = new Car("K9");
		System.out.println(
				"KiaMaker: " + car.getName() + "를 만들어 판다.");
		
		return car;
	}
	
}
