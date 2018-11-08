package com.example.demo.proxy.step2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test { // Client
	/*
	 * 빈 컨테이너에 HelloImpl 객체가 등록되었다면 
	 * Client는 HelloImpl 객체를 주입받아서 사용하게 되고
	 * 핵심 로직만 수행될 것이다.
	 * 
	 * 빈 컨테이너에 Proxy 객체가 등록되었다면 
	 * Client는 Proxy 객체를 주입받아서 사용하게 되고
	 * 핵심 로직과 핵심로직 앞뒤로 부가로직도 같이 수행될 것이다.
	 * 
	 * 결국, 빈 컨테이너 환경설정에서 Client가 사용할 로직을
	 * 결정할 수 있다. 변화되는 부분을 클래스에서 추출하여 
	 * 빈 컨테이너 환경설정으로 처리할 수 있게 되었다.
	 */
	@Autowired
	private Hello hello;
	
	public void order() {
		hello.say();
	}
	
	public static void main(String[] args) {
		Hello hello = new HelloImpl(); // Service
		
		hello.say();
		
		System.out.println();
		
		Hello proxy = new Proxy(hello);
		proxy.say();
	}

}
