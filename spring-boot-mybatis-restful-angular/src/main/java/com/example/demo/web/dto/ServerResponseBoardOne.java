package com.example.demo.web.dto;

import com.example.demo.board.model.Board;

import lombok.Data;

@Data
public class ServerResponseBoardOne {
	
	private String status = "Success";
	private String message;
	
	private Board board;
	
	private String errorCode;
	private String errorMessage;

	public ServerResponseBoardOne() {
		// Default Constructor
	}

	public ServerResponseBoardOne(Board board) {
		this.board = board;
	}

}