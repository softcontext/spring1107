package com.example.demo.dao;

// 클래스.스테틱메소드 인 경우,
// 임포트할 때, static 키워드를 사용하면,
// 작성하는 클래스내에서 클래스명은 생략하고 
// 바로 스테틱메소드를 사용할 수 있다.
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmpDaoImplTest {
	@Autowired
	private EmpDao dao;

	@Test
	public void testInsert() {
		int oldCount = dao.count(); // 3
		
		// 가짜 테스트 데이터 객체, PK인 empno 값은 설정하지 않는다.
		// empno 값은 디비가 자동으로 제너레이트 해서 넣을 것이다.
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Actor");
		emp.setSal(999);
		
		System.out.println("전: " + emp); // empno 값은 0인 상태
		
		int affected = dao.insert(emp);
		System.out.println("affected = " + affected); // 1
		
		System.out.println("후: " + emp); // empno 값은 디비가 자동으로 제너레이트 값!
		
		int nowCount = dao.count(); // 4
		
		assertThat("한 행이 추가되었으므로 nowCount는 oldCount 보다 1이 커야 합니다.", 
				nowCount, is(oldCount + 1));
		
		// 읽기 좋은 코드가 최선의 코드다. == 이해가 쉽게 된다.
		// 따라서, 최대한 읽기 좋게 작성하고 싶다.
		// (I) assert that nowCount is oldCount + 1.
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
		fail("Not yet implemented");
	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

}
