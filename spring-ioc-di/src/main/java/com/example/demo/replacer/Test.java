package com.example.demo.replacer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"method-replace-magic.xml");
		
		Magician magician = context.getBean(Magician.class);
		magician.show();
	}

}
