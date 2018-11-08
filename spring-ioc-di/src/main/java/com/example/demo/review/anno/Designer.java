package com.example.demo.review.anno;

import org.springframework.stereotype.Component;

@Component
public class Designer implements Employee {

	@Override
	public void work() {
		System.out.println("UI 화면을 디자인한다.");
	}

}
