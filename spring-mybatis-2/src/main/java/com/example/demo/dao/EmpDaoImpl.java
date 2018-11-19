package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Emp;

/*
 * 개발자가 @Mapper 애노테이션을 사용하는 대신 직접 인터페이스를 
 * 구현한 클래스를 작성하면 매퍼 XML에게 전달하는 파라미터 값을 
 * 조작할 수 있는 메소드 공간을 가질 수 있다. 
 * 더불어서 질의 결과를 조작할 수 있는 로직도 배치할 수 있다.
 */
@Repository
public class EmpDaoImpl implements EmpDao {
	/*
	 * SqlSessionTemplate 객체를 주입 받는다.
	 * 스프링 부트는 마이바티스 디펜던시를 선택하는 것만으로 
	 * 빈 컨테이너에 해당 객체가 등록되지만
	 * 스프링 레가시에서는 개발자가 직접 등록해야 한다.
	 */
	@Autowired
	private SqlSession session;
	
	@Override
	public int insert(Emp emp) {
		return session.insert(
				"com.example.demo.dao.EmpDao.insert", emp);
	}

	@Override
	public int update(Emp emp) {
		return session.update(
				"com.example.demo.dao.EmpDao.update", emp);
	}

	@Override
	public int delete(int empno) {
		return session.delete(
				"com.example.demo.dao.EmpDao.delete", empno);
	}

	@Override
	public List<Emp> findAll() {
		return session.selectList(
				"com.example.demo.dao.EmpDao.findAll");
	}

	@Override
	public int count() {
		return session.selectOne(
				"com.example.demo.dao.EmpDao.count");
	}

	@Override
	public Emp findOne(int empno) {
		return session.selectOne(
				"com.example.demo.dao.EmpDao.findOne", empno);
	}

	@Override
	public List<Emp> findByStartEnd(int start, int end) {
		Map<String, Integer> map = new HashMap<>();
        map.put("start", start); // 범위의 시작
        map.put("end", end); // 범위의 끝
	        
		return session.selectList(
				"com.example.demo.dao.EmpDao.findByStartEnd", map);
	}

	@Override
	public List<Emp> findBySkipLimit(int skip, int limit) {
		Map<String, Integer> map = new HashMap<>();
        map.put("skip", skip); // 스킵(건너 뜀)
        map.put("limit", limit); // 개수
	        
		return session.selectList(
				"com.example.demo.dao.EmpDao.findBySkipLimit", map);
	}

	@Override
	public List<Emp> findByPageSize(int page, int size) {
		// page, size 값을 이용하여 skip 값을 계산한다.
		int skip = 0;
		if (page > 0) {
			skip = (page - 1) * size;
		}
		
		// size와 limit는 논리적으로 같은 의미이다.
		Map<String, Integer> map = new HashMap<>();
        map.put("skip", skip); // 스킵(건너 뜀)
        map.put("limit", size); // 개수
        
		return session.selectList(
				"com.example.demo.dao.EmpDao.findByPageSize", map);
	}

	@Override
	public List<Emp> findByPageSizeUsingBind(int page, int size) {
		Map<String, Integer> map = new HashMap<>();
        map.put("page", page); // 페이지(몇 번째 화면)
        map.put("size", size); // 개수
        
		return session.selectList(
			"com.example.demo.dao.EmpDao.findByPageSizeUsingBind", map);
	}
	
	@Override
	public List<Emp> search(Map<String, String> map) {
		/*
		 * 매퍼 XML의 <if> 태그에서 제대로 된 값의 상태를 체크하기 위한 처리작업이 필요하다.
		 * 1. 빈 문자열을 null로 바꾼다. if 조건에서 null 값으로 비교할 수 있다.
		 * 2. if 조건에서 null 값으로 비교하는 대신 빈 문자열을 대상으로 체크한다.
		 */
		
		// #1 방식으로 사용하기 위한 처리작업을 수행한다.
		map.forEach((key, value) -> {
			if ("".equals(value)) {
				map.put(key, null);
			}
		});
		
		return session.selectList(
				"com.example.demo.dao.EmpDao.search", map);
	}

}
