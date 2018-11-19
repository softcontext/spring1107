package com.example.demo.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpDaoImplTest {
	@Autowired
	private EmpDao dao;

	@Test
	public void testInsert() {
		int oldCount = dao.count();

		// 가짜 테스트 데이터 객체, PK인 empno 값은 설정하지 않는다.
		// empno 값은 디비가 자동으로 제너레이트 해서 넣을 것이다.
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Actor");
		emp.setSal(999);

		System.out.println("전: " + emp); // empno 값은 0인 상태

		int affected = dao.insert(emp);
		System.out.println("insert affected = " + affected);

		System.out.println("후: " + emp); // empno 값은 디비가 자동으로 제너레이트 값!

		int nowCount = dao.count();

		assertThat("한 행이 추가되었으므로 nowCount는 oldCount 보다 1이 커야 합니다.", 
				nowCount, is(oldCount + 1));

		// 읽기 좋은 코드가 최선의 코드다. == 이해가 쉽다. == 협력 작업 시 유리하다.
		// 따라서, 최대한 읽기 좋게 작성하고 싶다. 매처 라이브러리가 지원하는 메소드를 사용하는 이유가 된다.
		// (I) assert that nowCount is oldCount + 1.
	}

	@Test
	public void testUpdate() {
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Actor");
		emp.setSal(999);

		System.out.println("입력 전: " + emp);

		// 수정 대상을 입력한다.
		int affected = dao.insert(emp);
		System.out.println("insert affected = " + affected);

		System.out.println("입력 후/수정 전: " + emp);

		emp.setJob("Developer");
		emp.setSal(2000);

		// 수정 메소드를 테스트한다.
		affected = dao.update(emp);
		System.out.println("update affected = " + affected);

		// 수정된 데이터를 확인하기 위해서 조회한다.
		Emp e = dao.findOne(emp.getEmpno());

		System.out.println("수정 후: " + e);

		assertThat(e.getJob(), is(emp.getJob()));
		assertThat(e.getSal(), is(emp.getSal()));

		// 테스트 시 사용한 로우를 삭제한다.
		// 대신 @Transactional 애노테이션을 @Test와 같이 사용해도 된다.
		affected = dao.delete(emp.getEmpno());
		System.out.println("delete affected = " + affected);
	}

	@Test
	public void testDelete() {
		int oldCount = dao.count();
		
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Actor");
		emp.setSal(999);

		// 삭제 대상을 입력한다.
		int affected = dao.insert(emp);
		System.out.println("insert affected = " + affected);
		
		/// 삭제 메소드를 테스트한다.
		affected = dao.delete(emp.getEmpno());
		System.out.println("delete affected = " + affected);
		
		int nowCount = dao.count();

		assertEquals(nowCount, oldCount);
	}

	@Test
	public void testFindAll() {
		System.out.println(dao instanceof EmpDaoImpl);
		
		List<Emp> emps = dao.findAll();
		emps.forEach(System.out::println);
		
		assertEquals(emps.size(), dao.count());
	}

	@Test
	public void testCount() {
		int count = dao.count();
		System.out.println("count = " + count);
		
		assertEquals(count, dao.findAll().size());
	}

	@Transactional
	@Test
	public void testFindOne() {
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Actor");
		emp.setSal(999);

		// 조회 대상을 입력한다.
		int affected = dao.insert(emp);
		System.out.println("insert affected = " + affected);
		
		Emp e = dao.findOne(emp.getEmpno());
		System.out.println(e);
		
		assertThat(e.getEname(), is(emp.getEname()));
		assertThat(e.getJob(), is(emp.getJob()));
		assertThat(e.getSal(), is(emp.getSal()));
	}

	@Test
	public void testFindBySkipLimit() {
		int skip = 10;
		int limit = 10;
		List<Emp> emps = dao.findBySkipLimit(skip, limit);
		emps.forEach(System.out::println);
	}
	
	@Test
	public void testFindByPageSize() {
		int page = 2;
		int size = 10;
		List<Emp> emps = dao.findByPageSize(page, size);
		emps.forEach(System.out::println);
	}
	
	@Test
	public void testFindByStartEnd() {
		int start = 11;
		int end = 20;
		List<Emp> emps = dao.findByStartEnd(start, end);
		emps.forEach(System.out::println);
	}
	
	@Test
	public void testFindByPageSizeUsingBind() {
		int page = 2;
		int size = 10;
		List<Emp> emps = dao.findByPageSizeUsingBind(page, size);
		emps.forEach(System.out::println);
	}
	
	@Test
	public void testSearch() {
		Map<String, String> map = new HashMap<>();
		map.put("ename", "일");
		map.put("job", "적");
		map.put("salMin", "200");
		map.put("salMax", "700");
		
		List<Emp> emps = dao.search(map);
		System.out.println(emps.size());
		emps.forEach(System.out::println);
	}
}
