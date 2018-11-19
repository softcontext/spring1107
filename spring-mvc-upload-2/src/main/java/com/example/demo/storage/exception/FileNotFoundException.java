package com.example.demo.storage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * 커스텀 예외를 @ResponseStatus 애노테이션과 함께 사용하면 
 * 예외가 컨트롤러 메소드에서 발생할 때 처리되지 않으면 
 * 자동적으로 상태코드를 가지고 리턴되는 적절한 HTTP 응답을 발생시킨다.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "File Not Found")
public class FileNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FileNotFoundException(String message) {
		super(message);
	}

	public FileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
