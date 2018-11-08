package com.example.demo.replacer;

import lombok.Data;

@Data
public class Magician {
	private MagicBox box;
	
	public void show() {
		System.out.println("마술사가 마술상자를 엽니다. 무엇이 나올까요?");
		String result = box.open();
		System.out.println("짜잔~! " + result + "가 나왔습니다.");
	}
}
