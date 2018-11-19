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

import com.example.demo.dao.EmpDao;
import com.example.demo.domain.Emp;

@Controller
@RequestMapping("/emps")
public class EmpController {
	@Autowired
	private EmpDao empDao;

	@GetMapping
	public String getSearchView() {
		return "search";
	}
	
	@PostMapping
	public Object postOne(
			@RequestParam Map<String, String> map, Model model) {
		
		// 브라우저는 검색화면에서 사용자가 직업란의 검색어를 입력하지 않아도 
		// job="" 형태로 파라미터를 전달한다.
		// 빈 문자열은 null이 아니므로 주의가 필요하다.
		System.out.println(map);
		// 예: {ename=길동, job=, salMin=, salMax=}
		
		List<Emp> emps = empDao.search(map);
		model.addAttribute("emps", emps);
		
		System.out.println(map);
		// 예: {ename=길동, job=null, salMin=null, salMax=null}
		
		model.addAttribute("conditions", searchConditionToHtml(map));
		
		return "search";
	}

	private String searchConditionToHtml(Map<String, String> map) {
		StringBuffer sb = new StringBuffer();
		sb.append("검색조건: ");
		if (map.get("ename") != null) {
			sb.append("<mark>Name=" + map.get("ename") + "</mark> ");
		}
		if (map.get("job") != null) {
			sb.append("<mark>Job=" + map.get("job") + "</mark> ");
		}
		if (map.get("salMin") != null) {
			sb.append("<mark>Salary Min=" + map.get("salMin") + "</mark> ");
		}
		if (map.get("salMax") != null) {
			sb.append("<mark>Salary Max=" + map.get("salMax") + "</mark> ");
		}
		if ("검색조건: ".equals(sb.toString())) {
			sb.append("<mark>ALL</mark>");
		}
		return sb.toString();
	}
}
