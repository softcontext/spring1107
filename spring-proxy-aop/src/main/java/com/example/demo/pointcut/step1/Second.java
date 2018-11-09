package com.example.demo.pointcut.step1;

public class Second {
	public void one() {
		System.out.println("Second # one()");
	}

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
