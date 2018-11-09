package com.example.demo.proxy.step5;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test { // 클라이언트
	@Autowired
	private Hello h;
	
	public void order() {
		h.say();
	}

	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.say();
		
		System.out.println();
		
//		Hello proxy = new Proxy();
//		proxy.say();
		
		Advice advice = new MyAdvice();
		
		// CGLIB Dynamic Proxy
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(hello);
		factory.addAdvice(advice);
		
		Hello proxy = (Hello) factory.getProxy();
		proxy.say();
		
		// 스프링은 전역적으로 프록시 객체를 만들어주는 AOP 서비스를 제공한다.
		// 부가로직을 재 사용하여 다수의 클래스를 프록싱하는 객체를 만들어야 하므로
		// 부가로직을 갖고 있는 어드바이스 클래스는 특정 클래스의 종속되면 안된다.
	}

}
