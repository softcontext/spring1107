package com.example.demo.lombok.step1;

import lombok.ToString;

public class EmpTest {

	public static void main(String[] args) {
		Emp emp = new Emp(10, "Jonh", "Developer");
		
		System.out.println(emp.getEname());
		
		System.out.println(emp.toString());
		System.out.println(emp);
		
		/*
		 * com.example.demo.lombok.step1.Emp@15db9742
		 * 
		 * Emp 클래스에서 toString() 메소드를 재 정의한 후
		 * 
		 * {10,Jonh,Developer}
		 * 
		 * @ToString 애노테이션으로 toString() 메소드를 재 정의한 후
		 * 
		 * Emp(empno=10, ename=Jonh, job=Developer)
		 */
	}

}
