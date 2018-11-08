package com.example.demo.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/example/demo/spel/etc-config.xml");
		
		User user = context.getBean("user", User.class);
		System.out.println(user);
		// User(name=일지매, age=19)
		
		Member member = context.getBean("member", Member.class);
		System.out.println(member);
		// Member(name=일지매님, age=20)
		
		Person person = context.getBean("person", Person.class);
		System.out.println(person);
		/*
		 * Person(
		 * 	name=일지매님, age=20, 
		 * 	carName=Bonggo, carDoors=2, 
		 * 	defaultLocale=KR)
		 */
	}
}