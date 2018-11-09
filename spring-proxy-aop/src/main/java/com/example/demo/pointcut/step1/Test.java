package com.example.demo.pointcut.step1;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Test {

	public static void main(String[] args) {
		
		Advice advice = new MyAdvice();
		
		/*
		* execution() : 사용하는 표현식 종류
		* * one*(..) : 리턴자료형 메소드명(파라미터) : 필수 설정 항목
		* * : all : 리턴자료형이 무엇이든 상관이 없다. void, int, Object...
		* one* : 메소드명이 one 문자열로 시작
		* (..) : 파라미터 개수가 0~N개 가능, 각 파라미터 자료형은 상관이 없다.
		* 포인트컷 조합 시 and, or , not을 사용할 수 있다.
		*/
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		
		// 클래스명은 상관이 없고 메소드명이 one으로 시작하는 모든 메소드에 어드바이스를 적용한다.
//		pointcut.setExpression("execution(* one*(..))");
		
		// int형의 파라미터 2개를 받는 메소드에 어드바이스를 적용한다.
//		pointcut.setExpression("execution(* *(int, int))");
		
		// 첫 번째 파라미터로 int형의 값을 받는 메소드에 어드바이스를 적용한다.
//		pointcut.setExpression("execution(* *(int, ..))");
		
		// 파라미터를 2개 이상 받는 메소드에 어드바이스를 적용한다.
//		pointcut.setExpression("execution(* *(*, *, ..))");
		
		// Second 클래스이고 메소드명에 "o"가 있는 메소드에 어드바이스를 적용한다.
//		pointcut.setExpression(
//			"execution(* com.example.demo.pointcut.step1.Second.*o*(..))");
		
		pointcut.setExpression(
			"execution(* com.example.demo.pointcut.step1..S*.*(..))");
		
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
		
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(new First());
//		factory.addAdvice(advice);
		factory.addAdvisor(advisor);
		
		First f = (First) factory.getProxy();
		f.one();
		f.one2();
		f.two();
		f.add(2, 3);
		
		System.out.println();
		
		ProxyFactory factory2 = new ProxyFactory();
		factory2.setTarget(new Second());
		factory2.addAdvisor(advisor);
		
		Second s = (Second) factory2.getProxy();
		s.one();
		s.one2();
		s.two();
		s.add(2, 3);
	}

}
