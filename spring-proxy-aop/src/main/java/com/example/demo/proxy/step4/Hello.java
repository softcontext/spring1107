package com.example.demo.proxy.step4;

// 인터페이스를 구현하고 있지 않은 Target 클래스
public class Hello {
	// 클라이언트가 프록시 객체를 사용하는 경우
	// 프록시 객체가 가진 전 처리 로직이 타겟 메소드 앞에서 기동한다.
	// System.out.println("----Around Before Advice----");
	
	public void say() {
		// 핵심로직
		System.out.println("Hello~!!!");
	}
	
	// 클라이언트가 프록시 객체를 사용하는 경우
	// 프록시 객체가 가진 후 처리 로직이 타겟 메소드 뒤에서 기동한다.
	// System.out.println("====Around After  Advice====");
}
