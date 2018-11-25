package com.example.demo.web.dto;

import lombok.Data;

@Data
public class ServerResponse {
	
	private String status = "Success";
	private String message;
	private String errorCode;
	private String errorMessage;

	public ServerResponse() {
		// Default Constructor
	}

}