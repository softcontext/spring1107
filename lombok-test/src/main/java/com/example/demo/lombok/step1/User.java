package com.example.demo.lombok.step1;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class User {
	@NonNull int id;
	@NonNull String name;
	String email;
	
//	public User(int id, String name, String email) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//	}
	
//	public User(int id, String name) {
//		super();
//		this.id = id;
//		this.name = name;
//	}
	
}
