package com.example.demo.dao;

import java.util.List;

import com.example.demo.domain.Emp;

public interface EmpDao {
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	
	public List<Emp> findAll();
	public int count();
	public Emp findOne(int empno);
	
	/*
	 * 테이블의 특정 범위의 로우들만을 조회하고 싶다.
	 * 
	 * 전제: 정렬은 이미 되어 있다. 또는 조회 시 마다 order by 구문을 사용한다.
	 * 기본적으로 거의 대부분의 디비는 PK의 오름차순으로 정렬한 상태로 데이터를 유지한다.
	 */
	
	// start: empno의 시작 값, end: empno의 종료 값
	public List<Emp> findByStartEnd(int start, int end);
	
	// skip: 앞에서부터 얼마나 스킵할 것인지에 대한 값, limit: 구하는 로우의 개수
	public List<Emp> findBySkipLimit(int skip, int limit);
	
	// page: ceil(전체 로우의 개수/size) 후 구해지는 페이지 번호, size: 구하는 로우의 개수
	/*
	 * 전체 로우의 개수 = 21
	 * size = 10
	 * ceil(21/10) = 3
	 */
	public List<Emp> findByPageSize(int page, int size);
}






