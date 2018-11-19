package com.example.demo.storage.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/*
 * @ConfigurationProperties를 적용한 클래스를 빈으로 등록하는 방법
 * 1. @EnableConfigurationProperties({ FileStorageProperties.class })
 * 2. 설정 프로퍼티 클래스에 @Configuration 적용하기 
 * 3. 설정 프로퍼티 클래스를 @Bean으로 등록하기
 * 빈으로 등록 했다면 이제 설정 정보가 필요한 곳에서 해당 빈을 주입받아 사용할 수 있다.
 */
@Data
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
	/*
	 *  uploadDir 변수명이 중간에 대문자를 포함하고 있는데 
	 *  이 경우 다음과 같은 프로퍼티로부터 값을 가져올 수 있다.
	 *  file.uploadDir
	 *  file.upload-dir
	 *  file.upload_dir
	 *  FILE_UPLOAD_DIR
	 *  설정 파일의 문자열을 프로퍼티 타입으로 스프링이 알아서 변환해 준다.
	 */
	private String uploadDir;
}
