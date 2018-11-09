package com.example.demo.pointcut.step2;

public class First {
	// 어드바이스 로직은 수행하지만 타겟 메소드는 호출하지 않는다.
	@AdviceRequired(required=false)
	public void one() {
		System.out.println("First # one()");
	}

	public void one2() {
		System.out.println("First # one2()");
	}

	public void two() {
		System.out.println("First # two()");
	}

	public int add(int a, int b) {
		System.out.println("First # add(int a, int b)");
		return a + b;
	}
}
