package com.example.demo.pointcut.step2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("-----Around Before Advice-----");
		
		boolean control = true;
		
		AdviceRequired ar = invocation
				.getMethod().getAnnotation(AdviceRequired.class);
		if (ar != null) {
			if (!ar.required()) {
				control = false;
			}
		}
		
		Object ret = null;
		
		if (control) {
			ret = invocation.proceed();
		}
		
		System.out.println("=====Around After Advice======");
		
		return ret;
	}
}
