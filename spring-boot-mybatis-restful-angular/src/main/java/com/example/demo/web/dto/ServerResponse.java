package com.example.demo.web.dto;

import com.example.demo.common.dto.Pager;

import lombok.Data;

@Data
public class ServerResponse {
	
	private String status = "Success";
	private String message;
	
	private Object data;
	private Pager pager;
	
	private String errorCode;
	private String errorMessage;

	public ServerResponse() {
		// Default Constructor
	}

	public ServerResponse(Object data) {
		this.data = data;
	}

	public ServerResponse(Object data, Pager pager) {
		this.data = data;
		this.pager = pager;
	}

}