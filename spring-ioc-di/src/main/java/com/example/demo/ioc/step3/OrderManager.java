package com.example.demo.ioc.step3;

public class OrderManager {
	// 비즈니스 환경에서 사용하는 프로그램은 변화의 요구가 극심합니다.
	// 현대자동차에게 주문하던 것을 기아자동차로 변경해야 하는 요구가 발생했다.
	
	// 1. 인터페이스 도입 효과
	CarMaker maker;
	
	public OrderManager() {
		maker = new HyundaiMaker();
//		maker = new KiaMaker();
	}
	
	// OrderManager의 거래처가 변화하더라도 
	// OrderManager 클래스 내에 코드의 변경을 막는 방법
	// 1. 인터페이스 도입
	// 2. 객체관리를 클래스내에서 직접하지 않는다.
	
	public void order() {
		System.out.println("OrderManager: order() called.");
		
		Money money = new Money(2000);
		System.out.println(
				"OrderManager: " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println(
				"OrderManager: 돈을 주고 " + car.getName() + "를 얻는다.");
	}
}
