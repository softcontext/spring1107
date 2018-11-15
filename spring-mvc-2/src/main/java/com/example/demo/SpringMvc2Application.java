package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringMvc2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvc2Application.class, args);
	}

	/*
	 * 브라우저 ==> https://www.google.com:80
	 * ==(HTML, JS, CSS)==> 브라우저 ==> HTML ==> JS 
	 * ==> https://www.google.com:9123 ==데이터==> JS 
	 * ==> 화면에 표시
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
				 	// 이 서버가 제공할 리소스에 접근하는 URI를 등록한다.
					.addMapping("/emps/**")
					// 이 서버에 데이터를 요구하는 도메인을 등록한다.
					// 특정 도메인을 등록하면 그 도메인이 주소창에 표시될 때만 허용하는 방식이다.
					.allowedOrigins("*")
					.allowedMethods(
						"GET", "POST", "DELETE", "PUT", "OPTIONS");
			}
		};
	}
}
