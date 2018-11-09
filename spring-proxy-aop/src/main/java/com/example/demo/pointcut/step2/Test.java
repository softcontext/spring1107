package com.example.demo.pointcut.step2;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class Test {

	public static void main(String[] args) {

		Advice advice = new MyAdvice();

		AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut
				.forMethodAnnotation(AdviceRequired.class);

		Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(new First());
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
