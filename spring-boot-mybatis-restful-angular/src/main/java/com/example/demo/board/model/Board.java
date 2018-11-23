package com.example.demo.board.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Board {
	private Long id;
	private String writer;
	private String title;
	private String content;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date regDate;
	private Long hitCount;
}
