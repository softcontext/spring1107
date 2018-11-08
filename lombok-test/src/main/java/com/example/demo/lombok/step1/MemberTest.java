package com.example.demo.lombok.step1;

public class MemberTest {

	public static void main(String[] args) {
		Member member = new Member(1, "Tom", "cruise@actor.com");

		System.out.println(member.getId());
		System.out.println(member.getName());
		System.out.println(member.getEmail());
	}

}
