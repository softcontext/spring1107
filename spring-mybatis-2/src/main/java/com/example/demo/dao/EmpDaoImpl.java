package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Emp;

@Repository
public class EmpDaoImpl implements EmpDao {
	// SqlSessionTemplate
	@Autowired
	private SqlSession session;
	
	@Override
	public int insert(Emp emp) {
		
		return 0;
	}

	@Override
	public int update(Emp emp) {
		
		return 0;
	}

	@Override
	public int delete(int empno) {
		
		return 0;
	}

	@Override
	public List<Emp> findAll() {
		return session
			.selectList("com.example.demo.dao.EmpDao.findAll");
	}

	@Override
	public int count() {
		
		return 0;
	}

	@Override
	public Emp findOne(int empno) {
		
		return null;
	}

	//-----------------------------------
	
	@Override
	public List<Emp> findByStartEnd(int start, int end) {
		Map<String, Integer> map = new HashMap<>();
        map.put("start", start);
        map.put("end", end); // 개수
	        
		return session
				.selectList(
					"com.example.demo.dao.EmpDao.findByStartEnd", 
					map);
	}

	@Override
	public List<Emp> findBySkipLimit(int skip, int limit) {
		Map<String, Integer> map = new HashMap<>();
        map.put("skip", skip);
        map.put("limit", limit); // 개수
	        
		return session
				.selectList(
					"com.example.demo.dao.EmpDao.findBySkipLimit", 
					map);
	}

	@Override
	public List<Emp> findByPageSize(int page, int size) {
		int skip = 0;
		if (page > 0) {
			skip = (page - 1) * size;
		}
		
		Map<String, Integer> map = new HashMap<>();
        map.put("skip", skip);
        map.put("limit", size); // 개수
        
		return session
				.selectList(
						"com.example.demo.dao.EmpDao.findByPageSize", 
						map);
	}

}
