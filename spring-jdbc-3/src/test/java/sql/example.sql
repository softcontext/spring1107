# CHICAGO에 근무하는 직원정보를 구한다.
# Divide and Conquer: 문제가 복잡하면 분할해서 해답을 구한다.

# CHICAGO에 있는 부서는 무엇인가?

select deptno from DEPT where loc='CHICAGO';
# 30

select * from EMP where deptno=30;
# 6명

# 위 2개의 쿼리를 묶어서 사용하는 Join 쿼리를 작성한다.
select * from EMP where deptno=(
	select deptno from DEPT where loc='CHICAGO'
);

# 테이블 데이터의 상태는 시시각각 변한다.
# 데이터의 상태에 따라 쿼리의 퍼포먼스도 변한다.
# 따라서, 여러 방식의 쿼리를 수행하여 최적의 
# 쿼리를 사용해야 한다.
