package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Emp;

@Repository
public class EmpDaoBatch {
	@Autowired
	public JdbcTemplate jdbcTemplate;
	@Autowired
	public NamedParameterJdbcTemplate nTemplate;

	public int[] batchUpdateUsingJdbcTemplate(List<Emp> emps) {
		String sql = "INSERT INTO emp (ename, job, sal) VALUES (?, ?, ?)";
		
		return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				
				Emp emp = emps.get(i);
				
				ps.setString(1, emp.getEname());
				ps.setString(2, emp.getJob());
				ps.setDouble(3, emp.getSal());
			}

			@Override
			public int getBatchSize() {
				return emps.size();
			}
		});
	}

	public int[][] batchUpdateUsingJdbcTemplateBatchSize(List<Emp> emps) {
		String sql = "INSERT INTO emp (ename, job, sal) VALUES (?, ?, ?)";
		
		// 큰 배치작업일 때, 50개 단위로 잘라서 처리할 수 잇다.
		return jdbcTemplate.batchUpdate(sql, emps, 50, new ParameterizedPreparedStatementSetter<Emp>() {
			@Override
			public void setValues(PreparedStatement ps, Emp emp) throws SQLException {
				ps.setString(1, emp.getEname());
				ps.setString(2, emp.getJob());
				ps.setDouble(3, emp.getSal());
			}
		});
	}

	public int[] batchUpdateUsingNamedParameterJdbcTemplate(List<Emp> emps) {
		String sql = "INSERT INTO emp (ename, job, sal) VALUES (:ename, :job, :sal)";
		
		SqlParameterSource[] batch = SqlParameterSourceUtils
				.createBatch(emps.toArray());
		
		int[] updateCounts = nTemplate.batchUpdate(sql, batch);
		return updateCounts;
	}
}
