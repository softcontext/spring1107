package com.example.demo.vo;

import lombok.Data;

// Browser == 다수의 파라미터 ~~스프링~~> User ==> 컨트롤러

@Data
public class User {
	private String id;
	private String pw;
}
