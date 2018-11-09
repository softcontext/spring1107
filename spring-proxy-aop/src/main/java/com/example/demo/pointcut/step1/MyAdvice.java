package com.example.demo.pointcut.step1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("-----Around Before Advice-----");
		
		Object ret = invocation.proceed();
		
		System.out.println("=====Around After Advice======");
		
		return ret;
	}
}
