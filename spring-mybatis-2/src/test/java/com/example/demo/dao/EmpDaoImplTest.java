package com.example.demo.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpDaoImplTest {
	@Autowired
	private EmpDao dao;

	@Test
	public void testInsert() {
		fail("Not yet implemented");
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
		System.out.println(dao instanceof EmpDaoImpl);
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
}





