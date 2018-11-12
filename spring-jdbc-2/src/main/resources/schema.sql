drop table if exists emp;

--identity : 디비가 지원하는 키 생성전략을 사용한다.
--H2는 자동으로 키 값을 제너레이트 한다.
create table emp (
	empno int identity not null primary key,
	ename varchar(100),
	job varchar(100),
	sal double
);