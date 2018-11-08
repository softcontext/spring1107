package com.example.demo.review.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * TeamManager use Employee.
 * TeamManager has Employee.
 * TeamManager depends Employee.
 */
@Data
@NoArgsConstructor
@Component("manager2")
public class TeamManager {
//	private Employee worker = new Programmer();
//	private Employee worker = new Designer();
	private Employee worker;
	
	@Autowired
	public TeamManager(@Qualifier("designer") Employee worker) {
		super();
		this.worker = worker;
	}
	
	public void order() {
		System.out.println("TeamManager가 " + 
				worker.getClass().getSimpleName() +"에게 일을 시킨다.");
		worker.work();
	}

}







