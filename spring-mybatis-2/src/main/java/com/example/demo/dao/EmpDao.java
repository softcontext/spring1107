package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import com.example.demo.domain.Emp;

public interface EmpDao {
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	
	public List<Emp> findAll();
	public int count();
	public Emp findOne(int empno);
	
	/*
	 * 테이블의 특정 범위의 로우들만을 조회하는 메소드 예제
	 * - findByStartEnd
	 * - findBySkipLimit
	 * - findByPageSize
	 * 
	 * 전제: 정렬은 이미 되어 있다. 거의 대부분의 디비는 PK의 오름차순으로 
	 * 정렬한 상태로 데이터를 유지한다. 또는 조회 시 마다 order by 구문을 사용한다.
	 */
	
	/*
	 * 1. 자바 개발자 입장에서 유리하다.
	 * start: empno의 시작 값, end: empno의 종료 값
	 */
	public List<Emp> findByStartEnd(int start, int end);
	
	/*
	 * 2. 디비 쿼리 작성 입장에서 유리하다.
	 * skip: 앞에서부터 얼마나 스킵할 것인지에 대한 값, limit: 구하는 로우의 개수
	 */
	public List<Emp> findBySkipLimit(int skip, int limit);
	
	/*
	 * 3. 사용자 입장(UX)에서 유리하다.
	 *   전체 로우의 개수 = 21
	 *   size 지정 값 = 10
	 *   총 페이지 수 = ceil(21/10) = 3
	 * page: 사용자의 선택 페이지 번호, size: 구하는 로우의 개수
	 */
	public List<Emp> findByPageSize(int page, int size);
	
	/*
	 * <bind> 태그 사용 예제
	 */
	public List<Emp> findByPageSizeUsingBind(int page, int size);
	
	/*
	 * 동적 쿼리 사용 예제
	 * ename, job, sal 칼럼으로 검색하는 기능의 메소드를 제공하고 싶다.
	 * 다음은 쿼리의 작성 예제이다. 필터링 조건을 단수 또는 복수로 연결하여 질의한다.
	 * select * from EMP where ENAME like '%길동%'
	 * select * from EMP where JOB like '%적%'
	 * select * from EMP where SAL >= 800 and SAL <= 900
	 * select * from EMP where SAL >= 800
	 * select * from EMP where SAL <= 900
	 */
	public List<Emp> search(Map<String, String> map);
}
