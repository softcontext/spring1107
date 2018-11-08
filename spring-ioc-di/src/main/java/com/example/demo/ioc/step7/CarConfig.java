package com.example.demo.ioc.step7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 이 클래스는 빈 설정정보를 갖고 있으니 처리하라고 요청한다.
@Configuration
public class CarConfig {
//	CarMaker maker = new KiaMaker(); // 객체생성
//	CarMaker maker = new HyundaiMaker(); // 객체생성
//	
//	OrderManager manager = new OrderManager(); // 객체생성
//	manager.setMaker(maker); // 관계설정
	
	// 메소드명을 id로 삼고 메소드가 리턴하는 객체를 빈 컨테이너에 등록하라.
	@Bean
	public CarMaker kiaMaker() {
		CarMaker maker = new KiaMaker();
		return maker;
	}
	
	@Bean(name="hyundaiMaker")
	public CarMaker hyundaiMaker() {
		CarMaker maker = new HyundaiMaker();
		return maker;
	}
	
	@Bean
	public OrderManager manager() {
		OrderManager manager = new OrderManager();
		manager.setMaker(kiaMaker());
		return manager;
	}
}
