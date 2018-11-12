package com.example.demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.model.Emp;

// 개발자 테스트 클래스 ~~ SpringJUnit[JUnit]
@RunWith(SpringJUnit4ClassRunner.class)
// 테스트를 위한 빈 컨테이너 설정파일을 통보한다.
// file: 파일의 기준위치는 자바 측이 아니라 웹 루트 밑이다라고 구분해 준다.
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class EmpDaoImplTest {
	@Autowired
	private EmpDao empDao;
	
	@Test
	public void testInsert() {
		// given: 무엇이 주어진 상황에서
		
		// when: 무엇을 변경할 때
		
		// then: 무슨 결과를 얻어야 한다.
		
		Emp emp = new Emp();
		emp.setEmpno(3201);
		emp.setEname("홍길동");
		emp.setJob("도둑");
		emp.setSal(999);
		
		int affected = empDao.insert(emp);
		
		System.out.println("affected = " + affected);
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
		List<Emp> emps = empDao.findAll();
		
		System.out.println(emps.size());
		
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}

	@Test
	public void testCount() {
		int count = empDao.count();
		System.out.println("count = " + count);
		
		// 단정메소드: 테스트 목적의 명확성, 테스트 자동화 및 코드의 가독성 향상을 위해서 사용한다.
		assertEquals(count, empDao.findAll().size());
	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

}
