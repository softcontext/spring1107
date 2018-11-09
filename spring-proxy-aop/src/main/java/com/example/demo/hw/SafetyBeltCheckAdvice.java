package com.example.demo.hw;

import java.util.Random;

public class SafetyBeltCheckAdvice {

	// 자동차에 start 메소드가 호출되면
	// 안전벨트 착용여부를 확인하여 
	// 착용했으면 엔진을 기동시키고
	// 착용하지 않았으면 경고음 들려줍니다.
}

class SafetyBeltCheckSensor {
	static Random rnd = new Random();
	
	public static boolean check() {
		if (rnd.nextInt(2) == 0) { 
			// 50% 확률로 true를 리턴한다.
			return true;
		}
		return false;
	}
}