package com.example.demo.review.anno;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//자료형이 같은 객체 다수가 빈 컨테이너에 존재할 때,
//처리순서를 지정한다. 낮은 숫자가 먼저 처리된다.
@Order(3)
@Component
public class Programmer implements Employee {

	@Override
	public void work() {
		System.out.println("프로그램 코드를 작성한다.");
	}

}
