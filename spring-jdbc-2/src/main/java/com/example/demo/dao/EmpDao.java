package com.example.demo.dao;

import java.util.List;

import com.example.demo.domain.Emp;

public interface EmpDao {
	// 수정쿼리: 입력, 수정, 삭제 작업, 테이블의 로우의 상태정보를 변화시킨다.
	// 리턴자료형 int: 작업결과로 영향받은 row의 개수를 의미합니다.
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	
	public int save(Emp emp);
	
	// 조회쿼리: 테이블의 로우의 상태정보가 변하지 않는다.
	public List<Emp> findAll();
	public int count();
	public Emp findOne(int empno);
}
