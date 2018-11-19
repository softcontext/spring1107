package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.demo.storage.property.FileStorageProperties;

/*
 * 스프링 부트는 /error를 위한 매핑을 제공한다. 
 * 이 뷰는 타임리프 템플릿의  error.html로 매핑된다. 
 * 만일 JSP를 사용하고 있다면 InternalResourceViewResolver가 설정되면서 
 * error.jsp로 매핑된다. /error 와 매핑되는 뷰가 없다면 
 * 스프링 부트는 "Whitelabel Error Page" 라 불리는 
 * 그 자신의 에러페이지를 보여준다.
 * server.error.whitelabel.enabled=true 디폴트 설정을
 * false 바꾸어 작동을 중지할 수 있다.
 */
@EnableConfigurationProperties({ FileStorageProperties.class })
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


