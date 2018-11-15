package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.Member;
import com.example.demo.validator.MemberValidator;

@Controller
//모델어트리뷰 아이디를 세션어트리뷰의 아이디로 설정하면
//자동으로 세션객체의 값을 메소드의 파라미터로 전달하고
//모델 어트리뷰의 값이 메소드의 파라미터로 전달된 후
//그 결과인 파라미터를 백업하는 행동을 수행합니다.
@SessionAttributes("member")
public class ExampleController2 {
	//자동으로 모든 뷰에게 전달됩니다.
	@ModelAttribute("member")
	public Member member() {
		return new Member("이름을 입력하세요", "주소를 입력하세요");
	}

	/*
	 * 사용자에게 많은 데이터를 받아야 하는 경우
	 * 한 화면에서 이를 모두 요구하면 사용자가 지치므로
	 * 데이터 작성을 몇 단계로 나누어서 처리하고 싶을 때까 있다.
	 * 예: 선수 등록 Wizard
	 */
	@RequestMapping("/step1")
	public String step1() {

		return "step1";
	}

	//1. 세션어트리뷰에 저장된 값을 member 객체에 할당됩니다.
	//2. step1 화면에서 작성한 name 정보가 member 객체에 할당됩니다.
	//3. member 객체를 세션어트리뷰에 백업합니다.
	@RequestMapping("/step2")
	public String step2(
			@ModelAttribute Member member, 
			HttpSession session) {
		System.out.println("step2: " + member);
		
		// #3 번 과정을 확인하는 코드
		System.out.println(session.getAttribute("member"));
		//Member(name=tom, address=주소를 입력하세요)
		System.out.println(session.getAttribute("member") == member);
		//true

		return "step2";
	}

	//1. 세션어트리뷰에 저장된 값을 member 객체에 할당됩니다.
	//이 때, name 값이 할당됩니다.
	//2. step2 화면에서 작성한 address 정보가 member 객체에 할당됩니다.
	//3. member 객체를 세션어트리뷰에 백업합니다.
	//이 때, member 객체는 1단계, 2단계에서 작성한 모든 정보를 갖고 있게 됩니다.
	@RequestMapping("/step3")
	public String step3(
			@ModelAttribute Member member, // 사용자가 보낸 데이터
			BindingResult result, // 사용자가 보낸 데이터와 관련한 에러 데이터
			HttpSession session,
			SessionStatus sessionStatus, 
			RedirectAttributes redirectAttributes, 
			Model model) {
		System.out.println("step3: " + member);
		
		System.out.println(session.getAttribute("member"));
		//Member(name=tom, address=seoul)
		System.out.println(session.getAttribute("member") == member);
		//true
		
		//유효성 검사: 에러가 있다면 bindingResult 객체에 결과가 담겨있다.
		MemberValidator valid = new MemberValidator();
		valid.validate(member, result);
		
		if (result.hasErrors()) {
			model.addAttribute("fail", "데이터가 부적합합니다.");
			return "step2";
		}
		
		//************************************
		//사용자로부터 받은 name, address 정보가 있는
		//Member 객체를 DAO 에게 보내어 디비에 저장하는 코드를
		//여기에 배치합니다.
		//************************************
		
		//세션어트리뷰를 통해 저장한 정보를 파괴합니다.
		sessionStatus.setComplete();
		
		//처리결과를 사용자에게 안내해야 합니다.
		//POST-REDIRECT-GET Pattern을 적용합니다.
		//https://en.wikipedia.org/wiki/Post/Redirect/Get
		//처리결과 데이터를 step4.jsp 에게 전달할 방법이 필요합니다.
		redirectAttributes.addFlashAttribute("result", "회원가입성공");
		
		return "redirect:step4";
	}

	@RequestMapping("/step4")
	public String step4() {
		// 선수 등록 완료 안내 페이지
		// 처리결과는 FlashAttribute 객체에 추가한 정보가
		// 자동으로 뷰에게 전달됩니다.
		// 뷰 처리가 끝나서 다시 DS에게 리턴될 때 
		// FlashAttribute 객체는 자동으로 파괴됩니다.
		return "step4";
	}
}
