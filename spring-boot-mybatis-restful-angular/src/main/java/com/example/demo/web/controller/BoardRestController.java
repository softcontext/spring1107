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

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
	
	/*
	 * @PathVariable 파리미터는 반드시 parameterType="path"로 설정하고 
	 * @RequestParam 파라미터는 parameterType="string"으로 설정해야 한다. 
	 * 잘못되면 정상적으로 api가 작동하지 않는다. 
	 */
	
	@GetMapping
	@ApiOperation(value = "게시판 글 목록 조회", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "조회 페이지 번호", required = true, 
			dataType = "string", paramType = "query", defaultValue = "1"),
		@ApiImplicitParam(name = "size", value = "한 페이지에 표시할 글 개수", required = false,
        	dataType = "string", paramType = "query", defaultValue = "20"),
		@ApiImplicitParam(name = "bsize", value = "페이징 버튼 표시 개수", required = false,
        	dataType = "string", paramType = "query", defaultValue = "10")
	})
	@ApiResponses({
		@ApiResponse(code = 200, message = "페이지 별 글 목록 조회 결과", response = ServerResponse.class)
	})	
	public Object getBoardsByLimit(
			@RequestParam(name="page", required=false, defaultValue="1") int page,
			@RequestParam(name="size", required=false, defaultValue="20") int size,
			@RequestParam(name="bsize", required=false, defaultValue="10") int bsize,
			HttpServletRequest req) {
		
		ServerResponse serverResponse = new ServerResponse();
		serverResponse.setMessage("글 목록");
		serverResponse.setData(boardMapper.findByLimit(page, size));
		serverResponse.setPager(new Pager(page, size, bsize, boardMapper.count(), req));
		
		return new ResponseEntity<ServerResponse>(
				serverResponse, headers, HttpStatus.OK);
	}

	@GetMapping("/{key}")
	@ApiOperation(value = "게시판 글 하나 조회", produces = "application/json")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "key", value = "게시판 글 고유키", required = true, 
    			dataType = "string", paramType = "path", defaultValue = "")
    })
	@ApiResponses({
		@ApiResponse(code = 200, message = "글 하나 조회 결과", response = ServerResponse.class)
	})
	public Object getBoardByKey(@PathVariable Long key) {
		boardMapper.increment(key);
		
		ServerResponse serverResponse = new ServerResponse(boardMapper.findById(key));
		
		return new ResponseEntity<ServerResponse>(
				serverResponse, headers, HttpStatus.OK);
	}

	@PostMapping
	@ApiOperation(value = "게시판 글 하나 등록", produces = "application/json")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "board", value = "글 정보 객체", required = true, 
    			dataType = "string", paramType = "body", defaultValue = "")
    })
	@ApiResponses({
		@ApiResponse(code = 200, message = "등록 결과", response = ServerResponse.class)
	})
	public Object postBoardOne(@RequestBody Board board) {
		boardMapper.insert(board);
		
		ServerResponse serverResponse = new ServerResponse(board);
		
		return new ResponseEntity<ServerResponse>(
				serverResponse, headers, HttpStatus.OK);
	}

	@PutMapping("/{key}")
	@ApiOperation(value = "게시판 글 하나 수정", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "key", value = "게시판 글 고유키", required = true, 
    			dataType = "string", paramType = "path", defaultValue = ""),
		@ApiImplicitParam(name = "board", value = "글 정보 객체", required = true, 
				dataType = "string", paramType = "body", defaultValue = "")
	})
	@ApiResponses({
		@ApiResponse(code = 200, message = "수정 결과", response = ServerResponse.class)
	})
	public Object putBoardByKey(@PathVariable Long key, @RequestBody Board board) {
		board.setId(key);
		
		boardMapper.update(board);
		
		ServerResponse serverResponse = new ServerResponse(board);
		
		return new ResponseEntity<ServerResponse>(
				serverResponse, headers, HttpStatus.OK);
	}

	@DeleteMapping("/{key}")
	@ApiOperation(value = "게시판 글 하나 삭제", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "key", value = "게시판 글 고유키", required = true, 
    			dataType = "string", paramType = "path", defaultValue = "")
	})
	@ApiResponses({
		@ApiResponse(code = 200, message = "삭제 결과", response = ServerResponse.class)
	})
	public Object deleteBoardByKey(@PathVariable Long key) {
		boardMapper.delete(key);
		
		ServerResponse serverResponse = new ServerResponse();
		
		return new ResponseEntity<ServerResponse>(
				serverResponse, headers, HttpStatus.OK);
	}
}
