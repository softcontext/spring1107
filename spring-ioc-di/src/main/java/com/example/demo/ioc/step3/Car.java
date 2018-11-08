package com.example.demo.ioc.step3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 상태를 보관하는 용도의 클래스를 관점에 따라서 다음과 같이 부른다.
 * VO(Value Object), DTO(Data Transfer Object), 
 * Domain, Model, Entity(ORM 기술에서 사용)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	private String name;
}
