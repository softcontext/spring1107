package com.example.demo.proxy.step3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 기존의 Proxy 클래스는 Hello 구현체만 프록싱 할 수 있었으나
// MyAdvice는 어떠한 타겟 객체도 프록싱할 수 있다.
public class MyAdvice implements InvocationHandler {
	// 어떠한 타겟 객체도 취급할 수 있도록 Object 자료형으로 지칭한다.
	private Object target;

	public MyAdvice(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 타겟 객체의 핵심로직 앞에서 수행하는 로직 = Before Advice
		System.out.println("---------"); 

		// 범용성을 확보하기 위해서는 특정 자료형이 노출되면 안된다.
		//((Hello) target).say();
		
		// 타겍 객체의 핵심로직을 호출한다.
		// target 객체안에 존재하고, Method 객체가 알고 있는 
		// 메소드를 호출하면서 파라미터로 args를 전달한다.
		Object ret = method.invoke(target, args); // 위임(Delegation)

		// 타겟 객체의 핵심로직 뒤에서 수행하는 로직 = After Advice
		System.out.println("=========");
		
		return ret;
	}

}
