package com.example.demo.aop.xml.step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop-xml-step4.xml");
		
		First f = context.getBean(First.class);
		f.one();
		f.one2();
		f.two();
		int result = f.add(2, 3);
		System.out.println("^^^^^^^^^^^^^^^^^^");
		System.out.println("result = " + result);
		System.out.println("^^^^^^^^^^^^^^^^^^");
		
		Second s = context.getBean(Second.class);
		s.one();
		s.one2();
		s.two();
		s.add(2, 3);
	}

}
