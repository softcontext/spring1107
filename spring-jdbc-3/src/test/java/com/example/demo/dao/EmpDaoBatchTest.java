package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpDaoBatchTest {
	@Resource(name = "empDaoBatch")
	private EmpDaoBatch dao;
	private List<Emp> emps = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		emps.add(new Emp().setEname("Tom").setJob("Actor").setSal(500));
		emps.add(new Emp().setEname("Chris").setJob("Teacher").setSal(500));
	}

	@Test
	public void testBatchUpdateUsingJdbcTemplate() {
		int[] affecteds = dao.batchUpdateUsingJdbcTemplate(emps);
		System.out.println(Arrays.toString(affecteds));
	}

	@Test
	public void testBatchUpdateUsingJdbcTemplateBatchSize() {
		int[][] affecteds = dao.batchUpdateUsingJdbcTemplateBatchSize(emps);
		for (int[] updates : affecteds) {
			System.out.println(Arrays.toString(updates));
		}
	}

	@Test
	public void testBatchUpdateUsingNamedParameterJdbcTemplate() {
		int[] affecteds = dao.batchUpdateUsingNamedParameterJdbcTemplate(emps);
		System.out.println(Arrays.toString(affecteds));
	}
}
