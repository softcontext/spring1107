package com.example.demo.ioc.step4;

public class Test {
	// 왜? 프레임워크를 사용하는가?
	// 차 안타고 걸어다니셔도 됩니다.
	// 스프링은 100개 이상의 라이브러리 집합체입니다.
	// 왜? Inversion of Control 개념을 적용해야 하는가?
	// IoC는 객체를 관리하는 주체가 역전되었음을 의미한다.
	// 개발자 ==> 프레임워크
	// 개발자 객체를 직접 관리하지 않고 프레임워크가 대신 객체를 관리합니다.
	
	public static void main(String[] args) {
//		CarMaker maker = new KiaMaker(); // 객체생성
		CarMaker maker = new HyundaiMaker(); // 객체생성
		
		OrderManager manager = new OrderManager(); // 객체생성
		manager.setMaker(maker); // 관계설정
		manager.order(); // 로직호출

	}

}
