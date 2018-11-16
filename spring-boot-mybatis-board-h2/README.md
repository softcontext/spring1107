# 작업순서

# SQL 쿼리를 로그로 출력하는 설정

#### pom.xml

```xml
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-cache</artifactId>
	</dependency>

	<!-- JSTL for JSP -->
	<dependency>
		<groupId>javax.servlet</groupId>
		<artifactId>jstl</artifactId>
	</dependency>

	<!-- Need this to compile JSP -->
	<dependency>
		<groupId>org.apache.tomcat.embed</groupId>
		<artifactId>tomcat-embed-jasper</artifactId>
		<scope>provided</scope>
	</dependency>

	<dependency>
		<groupId>org.bgee.log4jdbc-log4j2</groupId>
		<artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
		<version>1.16</version>
	</dependency>
```

#### application.properties

```properties
#spring.datasource.driverClassName=org.h2.Driver
spring.datasource.driver-class-name=net.sf.log4jdbc.sql.jdbcapi.DriverSpy
#spring.datasource.url=jdbc:h2:mem:TESTDB;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.url=jdbc:log4jdbc:h2:mem:TESTDB;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.username=sa
spring.datasource.password=

logging.config=classpath:logback-spring.xml
```

#### logback-spring.xml

```xml
<logger name="jdbc" level="OFF" />
<logger name="jdbc.sqlonly" level="DEBUG" additivity="false">
	<appender-ref ref="STDOUT" />
	<appender-ref ref="FILE" />
</logger>
<logger name="jdbc.resultsettable" level="DEBUG" additivity="false">
	<appender-ref ref="STDOUT" />
	<appender-ref ref="FILE" />
</logger>
```

#### log4jdbc.log4j2.properties

log4jdbc.spylogdelegator.name 정보를 제공
