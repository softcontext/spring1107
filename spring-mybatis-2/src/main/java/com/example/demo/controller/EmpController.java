package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.EmpDao;
import com.example.demo.domain.Emp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emps")
public class EmpController {
	@Autowired
	private EmpDao empDao;

	// http://localhost:8080/emps
	@GetMapping
	public String getSearchView() {
		return "search";
	}
	
	@PostMapping
//	@ResponseBody
	public Object postOne(
			@RequestParam Map<String, String> map, Model model) {
		log.debug(map.toString());
		
		List<Emp> emps = empDao.search(map);
		model.addAttribute("emps", emps);
		
		return "search";
		
//		System.out.println(map.get("job") == null); // false
//		System.out.println(map.get("job") instanceof String); // true
//		return map;
	}
}
