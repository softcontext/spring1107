package com.example.demo.proxy.step7;

// 인터페이스를 구현하고 있지 않은 Target 클래스
public class Hello {
	private String who;
	
	public void say() {
		// 핵심로직
		System.out.println("Hello~!!!");
	}
}
