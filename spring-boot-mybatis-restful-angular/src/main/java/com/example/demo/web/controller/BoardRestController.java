package com.example.demo.web.controller;

import java.nio.charset.Charset;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.model.Board;
import com.example.demo.common.dto.Pager;
import com.example.demo.web.dto.ServerResponse;

@RestController
@RequestMapping("/boards")
public class BoardRestController {
	@Autowired
	private BoardMapper boardMapper;

	private HttpHeaders headers = new HttpHeaders();
	
	@PostConstruct
	public void init() {
		headers.setContentType(
			new MediaType(MediaType.APPLICATION_JSON, 
				Charset.forName("UTF-8")));
	}
	
	@GetMapping
	public Object getBoardByPage(
			@RequestParam(name="page", required=false, defaultValue="1") int page,
			@RequestParam(name="size", required=false, defaultValue="20") int size,
			@RequestParam(name="bsize", required=false, defaultValue="10") int bsize,
			HttpServletRequest req) {
		
		ServerResponse serverResponse = new ServerResponse();
		serverResponse.setData(boardMapper.findByLimit(page, size));
		serverResponse.setPager(new Pager(page, size, bsize, boardMapper.count(), req));
		
		return new ResponseEntity<ServerResponse>(
				serverResponse, headers, HttpStatus.OK);
	}

	@GetMapping("/{key}")
	public Object getBoardByKey(@PathVariable Long key) {
		boardMapper.increment(key);
		
		ServerResponse serverResponse = new ServerResponse();
		serverResponse.setData(boardMapper.findById(key));
		
		return new ResponseEntity<ServerResponse>(
				serverResponse, headers, HttpStatus.OK);
	}

	@PostMapping
	public Object postBoardOne(@RequestBody Board board) {
		boardMapper.insert(board);
		
		ServerResponse serverResponse = new ServerResponse(board);
		
		return new ResponseEntity<ServerResponse>(
				serverResponse, headers, HttpStatus.OK);
	}

	@PutMapping("/{key}")
	public Object putBoardByKey(@PathVariable Long key, @RequestBody Board board) {
		board.setId(key);
		
		boardMapper.update(board);
		
		ServerResponse serverResponse = new ServerResponse(board);
		
		return new ResponseEntity<ServerResponse>(
				serverResponse, headers, HttpStatus.OK);
	}

	@DeleteMapping("/{key}")
	public Object deleteBoardByKey(@PathVariable Long key) {
		boardMapper.delete(key);
		
		ServerResponse serverResponse = new ServerResponse();
		
		return new ResponseEntity<ServerResponse>(
				serverResponse, headers, HttpStatus.OK);
	}
}
