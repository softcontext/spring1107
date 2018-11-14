package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.demo.dao.EmpDao;
import com.example.demo.model.Emp;

//클래스에 트랜잭션 설정을 하면 이 안에 있는 모든 메소드에 트랜잭션이 적용됩니다.
//서비스 메소드에서 다수의 DAO 메소드를 호출하면, 그 메소드 모두 하나의 트랜잭션
//단위로 처리됩니다.
@Transactional(
	isolation=Isolation.DEFAULT,
	propagation=Propagation.REQUIRED,
	timeout=-1,
	readOnly=false)
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao empDao;
	@Autowired
	private DataSourceTransactionManager transactionManager;

	// 개발자가 직접 트랜잭션을 적용하는 예제
	@Override
	public int insert(Emp emp) throws Exception {
		// 트랜잭션과 관련한 4가지 속성을 어떻게 적용할 것인가와 관련한 정보를 취급하는 객체
		DefaultTransactionDefinition transactionDefinition = 
				new DefaultTransactionDefinition();
		
		// 아래 설정은 모두 디폴트 값을 사용하고 있다.
		transactionDefinition.setPropagationBehavior(
				TransactionDefinition.PROPAGATION_REQUIRED);
		transactionDefinition.setIsolationLevel(
				TransactionDefinition.ISOLATION_DEFAULT);
		// 시간제한을 두지 않고 계속 기다린다.
		transactionDefinition.setTimeout(-1); 
		// 조회쿼리를 수행할 때 true로 변경하면
		// 이 트랜잭션을 제치고 다른 트랜잭션이 먼저 작업하는 것을 허용한다.
		transactionDefinition.setReadOnly(false);
		
		// 이 객체를 이용하여 나중에 Rollback 또는 Commit을 적용할 때 사용한다.
		TransactionStatus transactionStatus = transactionManager
				.getTransaction(transactionDefinition);
		
		int affected = 0;
		
		try {
			
			// 상단 부분 코드 : Around:Before Advice
			// ************************************
			
			// Delegation: 타겟 메소드의 핵심로직을 호출한다.
			affected = empDao.insert(emp);
			
			// 이해를 돕기 위해서 추가로 여러 DAO의 여러 메소드를 호출하는 로직이 있다고 가정하자.
						
			// ************************************
			// 하단 부분 코드 : Around:After Advice
			
			transactionManager.commit(transactionStatus);
		} catch (Exception e) {
			transactionManager.rollback(transactionStatus);
			throw e;
		}
		return affected;
	}

	@Override
	public int update(Emp emp) throws Exception {
		return empDao.update(emp);
	}

	@Override
	public int delete(int empno) throws Exception {
		return empDao.delete(empno);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Emp> findAll() throws Exception {
		return empDao.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public int count() throws Exception {
		return empDao.count();
	}

	@Transactional(readOnly=true)
	@Override
	public Emp findOne(int empno) throws Exception {
		return empDao.findOne(empno);
	}
}
