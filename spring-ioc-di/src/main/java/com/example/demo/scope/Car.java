package com.example.demo.scope;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("car2")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope("prototype")
@Data
public class Car {
	private String name;
	private String maker;
	
	public Car() {
//		this.name = "K9";
//		this.maker = "Kia";
	}

	@PostConstruct
	public void init() {
		if (name == null || maker == null) {
			this.name = "K9";
			this.maker = "Kia";
		}
	}
}
