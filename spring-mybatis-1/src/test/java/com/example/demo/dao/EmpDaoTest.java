package com.example.demo.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpDaoTest {
	@Autowired
	private EmpDao dao;

	@Test
	public void testInsert() {
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Actor");
		emp.setSal(999);
		
		System.out.println("전 : " + emp);
		
		int affected = dao.insert(emp);
		System.out.println("affected = " + affected);
		
		/*
		 * 새 로우를 입력합니다.
		 * 디비가 생성한 키 값을 알고 싶어요.
		 * 어떻게 하나요?
		 * 
		 * 1. 메소드 호출 시 파라미터로 객체를 전달한다.
		 * 2. 마이바티스가 이 객체에 "setEmpno(디비가 생성한 키 값)" 
		 * 코드를 호출하여 저장합니다. <== 명시적인 설정이 필요!
		 * 3. 해당 객체는 이 위치에서 접근 가능한 변수이므로
		 * 직접 객체에서 꺼내서 사용할 수 있다.
		 */
		System.out.println("후 : " + emp);
		
		testFindAll();
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		dao.findAll().forEach(System.out::println);
	}

	@Test
	public void testCount() {
		System.out.println(dao.count());
	}

	@Test
	public void testFindOne() {
		try {
			Emp emp = dao.findOne(1);
			System.out.println(emp);
		} catch (Exception e) {
			throw e;
		}
	}

}
