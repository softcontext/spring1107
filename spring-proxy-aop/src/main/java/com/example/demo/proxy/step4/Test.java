package com.example.demo.proxy.step4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.proxy.step4.Hello;

@Component
public class Test { // 클라이언트
	@Autowired
	private Hello h;
	
	public void order() {
		// 스프링이 
		// 1. Hello 객체를 DI 하면 클라이언트는 직접 타겟 메소드를 사용한다.
		// 2. Proxy 객체를 DI 하면 클라이언트는 프록시 메소드를 사용한다.
		// 프록시 메소드 내에서 대신  타겟 메소드를 호출한다.
		h.say();
	}
	
	public static void main(String[] args) {
		Hello hello = new Hello();
		
		// 팬(클라이언트) ==> 가수(타겟)
		hello.say();
		
		System.out.println();
		
		Hello proxy = new Proxy();
		
		// 팬(클라이언트) ==> 매니저(프록시) ==> 가수(타겟)
		proxy.say();
	}

}
