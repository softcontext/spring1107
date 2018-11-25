package com.example.demo.board.service;

import com.example.demo.board.model.Board;

public interface BoardService {
	public Board findByIdAfterIncrementHitCount(Long key);
}
