package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.board.model.Board;

@Mapper
public interface BoardMapper {
	
	public void insert(Board board);

	public void update(Board board);

	public void delete(Long id);

	@Select("SELECT COUNT(*) FROM board")
	public int count();

	@Select("SELECT * FROM board ORDER BY id DESC")
	public List<Board> findAll();

	public Board findById(Long id);

	public List<Board> findByLimit(
			@Param("page") int page, @Param("size") int size);

	public void increment(Long id);
	
}
