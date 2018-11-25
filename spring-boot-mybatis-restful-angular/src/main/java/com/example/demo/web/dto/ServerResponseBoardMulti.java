package com.example.demo.web.dto;

import java.util.List;

import com.example.demo.board.model.Board;
import com.example.demo.common.dto.Pager;

import lombok.Data;

@Data
public class ServerResponseBoardMulti {

	private String status = "Success";
	private String message;

	private List<Board> boards;
	private Pager pager;

	private String errorCode;
	private String errorMessage;

	public ServerResponseBoardMulti() {
		// Default Constructor
	}

	public ServerResponseBoardMulti(List<Board> boards) {
		this.boards = boards;
	}

	public ServerResponseBoardMulti(List<Board> boards, Pager pager) {
		this.boards = boards;
		this.pager = pager;
	}

}