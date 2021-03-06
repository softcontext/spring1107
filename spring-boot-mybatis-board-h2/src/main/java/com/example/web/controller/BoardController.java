package com.example.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.board.dto.Pager;
import com.example.board.model.Board;
import com.example.board.repository.BoardMapper;
import com.example.user.model.User;

@Controller
@RequestMapping("/boards")
public class BoardController {
	@Autowired
	private BoardMapper boardMapper;
	
	@ModelAttribute("active")
	public String active(){
		return "board";
	}
	
	@GetMapping()
	public ModelAndView getBoardsView(
			@RequestParam(name="page", required=false, defaultValue="1") int page,
			@RequestParam(name="size", required=false, defaultValue="20") int size,
			@RequestParam(name="bsize", required=false, defaultValue="10") int bsize,
			HttpServletRequest req) {
		System.out.println(req.getRequestURL());
		// http://localhost:8080/boards
		
//		ModelAndView mav = new ModelAndView("board_list");
//		// 게시글 데이터
//		mav.addObject("boards", boardMapper.selectByLimit(page, size));
//		// 페이징 처리와 관련된 데이터
//		mav.addObject("pager", new Pager(page, size, bsize, boardMapper.count()));
		
		ModelAndView mav = new ModelAndView("board_list2");
		
		// 게시글 데이터
		mav.addObject("boards", boardMapper.selectByLimit(page, size));
		
		// 페이징 처리와 관련된 데이터
//		mav.addObject("pager", new Pager(page, size, bsize, 
//				boardMapper.count(), req.getRequestURL().toString()));
		
		// 페이징 처리와 관련된 데이터
//		mav.addObject("pager", new Pager(page, 
//				boardMapper.count(), req.getRequestURL().toString()));

		// 페이징 처리와 관련된 데이터
		mav.addObject("pager", new Pager(page, size, bsize, 
				boardMapper.count(), req));
		
		// 페이징 처리와 관련된 데이터
//		mav.addObject("pager", new Pager(page, 
//				boardMapper.count(), req));		
		
		return mav;
	}
	
	@GetMapping("/view/{id}")
	public ModelAndView getBoardView(@PathVariable long id) {
		boardMapper.increment(id);
		ModelAndView mav = new ModelAndView("board_view");
		mav.addObject("board", boardMapper.selectById(id));
		return mav;
	}
	
	@GetMapping("/write")
	public String getInsertView(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		model.addAttribute("user", user);
		return "board_write";
	}
	
	@PostMapping("/write")
	public String postInsert(Board board, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		if (user != null && board != null) {
			if (user.getEmail().equals(board.getWriter())) {
				boardMapper.insert(board);
			}
		}
		return "redirect:/boards";
	}
	
	@GetMapping("/update/{id}")
	public String getUpdateView(@PathVariable long id, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		Board board = boardMapper.selectById(id);
		
		if (user != null && board != null) {
			if (user.getEmail().equals(board.getWriter())) {
				model.addAttribute("board", board);
				return "board_update";
			}
		}
		return "redirect:/boards";
	}
	
	@PostMapping("/update")
	public String postUpdate(Board board, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		if (user != null && board != null) {
			if (user.getEmail().equals(board.getWriter())) {
				boardMapper.update(board);
				return "redirect:/boards/view/" + board.getId();
			}
		}
		return "redirect:/boards";
	}
	
	@GetMapping("/delete/{id}")
	public String getDelete(@PathVariable long id, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		
		if (user != null) {
			Board board = boardMapper.selectById(id);
			
			if (user.getEmail().equals(board.getWriter())) {
				boardMapper.delete(id);
			}
		}
		return "redirect:/boards";
	}
	
}
