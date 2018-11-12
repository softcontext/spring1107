package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 
스프링 부트 기술을 위한 환경을 구성한다.
@SpringBootConfiguration

디펜던시 및 application.properties 파일의 설정에 따라 환경을 구성한다.
@EnableAutoConfiguration

베이스패키지가 생략되면 클래스의 패키지를 베이스패키지로 사용한다.
excludeFilters: 자동환경 설정에 다음 클래스는 처리하지 말라.
exclude={ DataSourceAutoConfiguration.class } 설정을 추가하면
DataSource가 자동으로 처리되지 않아서 빈 컨테이너에 존재하지 않는다.
개발자가 직접 수동으로 하고자 할 때 사용할 수 있다.
개발자가 다른 곳에서 설정을 한다면 스프링부트는 그 설정을 존중하여 자동환경 설정을 
진행하지 않는다.

@ComponentScan(excludeFilters = {
		@Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
 */
@SpringBootApplication
public class SpringJdbc2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbc2Application.class, args);
	}
}
