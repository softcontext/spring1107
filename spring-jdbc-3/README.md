# 한글처리

#### character 셋 조회

```sql
show variables like 'c%';
```

#### my.ini 초기 설정

```ini
[mysqld] 
datadir=C:/Program Files/MariaDB 10.3/data 
port=3306 
sql_mode="STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION" 
default_storage_engine=innodb 
innodb_buffer_pool_size=1022M 
innodb_log_file_size=50M 
[client] 
port=3306
```

#### my.ini 변경 내용

```ini
[mysqld]
datadir=C:/Program Files/MariaDB 10.3/data
port=3306
sql_mode="STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION"
default_storage_engine=innodb
innodb_buffer_pool_size=255M
innodb_log_file_size=50M
init_connect = "SET collation_connection = utf8_general_ci"
init_connect = "SET NAMES utf8"
character-set-server = utf8
collation-server = utf8_general_ci

[client]
default-character-set = utf8

[mysqldump]
default-character-set = utf8

[mysql]
default-character-set = utf8
```

유의사항은 mysqld에는 default-character-set은 추가하면 안된다.

#### test 디비 한글처리

마리아디비를 설치하면 생기는 test 디비는 위 설정에 영향을 받지 않는다.

test 디비에서 한글을 사용하기 위해서 테이블을 생설할 때 추가적으로

다음 옵션을 설정하자. `CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'`

```sql
CREATE TABLE emp (
	empno INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	ename VARCHAR(100),
	job VARCHAR(100),
	sal DOUBLE
) ENGINE=InnoDB CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
```

# HeidiSQL Warning

HeidiSQL을 사용해서 프로시저를 생성할 때 뜨는 창은 예외가 아니라 
단순한 정보다. 다음 사이트를 참고하자.

https://bugs.mysql.com/bug.php?id=2839

다음 쿼리는 확인하면 로그 Level이 Note인 것을 알 수 있다. 

```sql
SHOW WARNINGS;
```
