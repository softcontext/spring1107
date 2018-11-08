package com.example.demo.lombok.step1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/*
 * Equivalent to 
 * 	@Getter 
 * 	@Setter 
 * 	@RequiredArgsConstructor 
 * 	@ToString 
 * 	@EqualsAndHashCode.
 */
@Data 
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Member {
	@NonNull private int id;
	@NonNull private String name;
	private String email;
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}

}




