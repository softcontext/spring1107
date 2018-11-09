package com.example.demo.aop.xml.step2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

// Around Advice 로직은 MethodInterceptor 인터페이스를 구현합니다.
// 타겟 메소드의 전달되는 파라미터를 조작하거나,
// 타겟 메소드 로직 처리 후 리턴하는 리턴 값을 조작하고 싶을 때 주로 어라운드 어드바이스를 사용합니다.
@Component
public class MyAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("-----Around Before Advice-----");
		
		Object ret = invocation.proceed();
		
		System.out.println("=====Around After Advice======");
		
		return ret;
	}
}
