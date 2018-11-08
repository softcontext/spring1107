package com.example.demo.proxy.step3;

// Target : 항상 처리해야 하는 로직을 제공하는 객체
public class HelloImpl implements Hello {

	@Override
	public void say() {
		// 항상 처리해야 하는 로직만 배치한다. : Primary Concern
		System.out.println("Hello~!!!");
	}

}
