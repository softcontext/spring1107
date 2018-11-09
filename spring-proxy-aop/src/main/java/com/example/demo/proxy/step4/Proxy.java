package com.example.demo.proxy.step4;

// 타겟 클래스를 대신하는 프록시도 클라이언트 입장에서
// 같은 자료형으로 접근 할 수 있도록 
// 즉, 프록시 클래스가 타겟 클래스로 업캐스팅이 가능하도록
// 관계를 맺어주어야 한다.
public class Proxy extends Hello {
	@Override
	public void say() {
		System.out.println("----Around Before Advice----");
		
		// 핵심로직을 호출한다.
		super.say();
		
		System.out.println("====Around After  Advice====");
	}
}
