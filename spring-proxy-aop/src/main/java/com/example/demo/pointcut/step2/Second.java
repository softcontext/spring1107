package com.example.demo.pointcut.step2;

public class Second {
	public void one() {
		System.out.println("Second # one()");
	}

	// 어드바이스 로직을 수행하고 타겟 메소드도 호출한다.
	@AdviceRequired
	public void one2() {
		System.out.println("Second # one2()");
	}

	public void two() {
		System.out.println("Second # two()");
	}

	public double add(double a, double b) {
		System.out.println("Second # add(double a, double b)");
		return a + b;
	}
}
