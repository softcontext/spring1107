package com.example.demo.ioc.step7;

public class OrderManager {
	CarMaker maker;

	public OrderManager() {
		
	}
	
	public OrderManager(CarMaker maker) {
		super();
		this.maker = maker;
	}

	public void order() {
		System.out.println("OrderManager: order() called.");
		
		Money money = new Money(2000);
		System.out.println(
				"OrderManager: " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println(
				"OrderManager: 돈을 주고 " + car.getName() + "를 얻는다.");
	}

	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}

}
