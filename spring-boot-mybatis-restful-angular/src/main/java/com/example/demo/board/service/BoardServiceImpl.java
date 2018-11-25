package com.example.demo.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.model.Board;

@Transactional
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public Board findByIdAfterIncrementHitCount(Long key) {
		boardMapper.increment(key);
		return boardMapper.findById(key);
	}

}
