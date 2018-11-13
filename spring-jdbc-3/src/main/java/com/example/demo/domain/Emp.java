package com.example.demo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
//setter 메소드가 this를 리턴하여 메소드 체이닝 패턴을 사용할 수 있다.
@Accessors(chain = true) 
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private double sal;
}
