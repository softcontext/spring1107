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

		assertThat("한 행이 추가되었으므로 nowCount는 oldCount 보다 1이 커야 합니다.", nowCount, is(oldCount + 1));

		// 읽기 좋은 코드가 최선의 코드다. == 이해가 쉽게 된다.
		// 따라서, 최대한 읽기 좋게 작성하고 싶다.
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

		System.out.println("수정 전: " + emp);

		emp.setJob("None");
		emp.setSal(0);

		// 수정을 테스트한다.
		affected = dao.update(emp);
		System.out.println("update affected = " + affected);

		// 수정된 칼럼 데이터를 확인하기 위해서 조회한다.
		Emp e = dao.findOne(emp.getEmpno());

		System.out.println("수정 후: " + e);

		assertThat(e.getJob(), is(emp.getJob()));
		assertThat(e.getSal(), is(emp.getSal()));

		// 테스트 시 사용한 로우를 삭제한다.
		affected = dao.delete(emp.getEmpno());
		System.out.println("delete affected = " + affected);
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

	@Test
	public void testSave() {
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setJob("Actor");
		emp.setSal(999);
		
		System.out.println("저장 전: " + emp);
		
		// Insert
		int affected = ((EmpDaoImpl)dao).save(emp);
		System.out.println("insert affected = " + affected);
		System.out.println("저장 후/수정 전: " + emp);
		emp.setJob("None");
		emp.setSal(0);
		
		// Update
		affected = dao.save(emp);
		System.out.println("update affected = " + affected);
		
		// Select
		Emp e = dao.findOne(emp.getEmpno());
		System.out.println("수정 후: " + e);
		
		// Delete
		affected = dao.delete(e.getEmpno());
		System.out.println("delete affected = " + affected);
	}
}
