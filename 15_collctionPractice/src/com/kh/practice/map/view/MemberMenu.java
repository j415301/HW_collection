package com.kh.practice.map.view;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.map.controller.MemberController;
import com.kh.practice.map.model.vo.Member;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	
	public void mainMenu() {
		System.out.println("========== KH 사이트 ==========");
		
		while (true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료");
			System.out.println();
			
			System.out.print("메뉴 번호 선택 : ");
			switch (sc.nextInt()) {
				case 1: joinMembership(); break;
				case 2: login(); memberMenu(); break;
				case 3: sameName(); break;
				case 9: System.out.println("프로그램 종료"); return;
				default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}
	
	
	public void memberMenu() {
		System.out.println("******* 회원 메뉴 *******");
		
		System.out.println("1. 비밀번호 바꾸기");
		System.out.println("2. 이름 바꾸기");
		System.out.println("3. 로그아웃");
		System.out.println();
		
		System.out.print("메뉴 번호 선택 : ");
		switch (sc.nextInt()) {
			case 1: changePassword(); break;
			case 2: changeName(); break;
			case 3: System.out.println("로그아웃 되었습니다."); return;
			default: System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
		}
	}
	
	
	public void joinMembership() {
		while (true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String pw = sc.next();
			System.out.print("이름 : ");
			String name = sc.next();
			
			Member m = new Member(pw, name);
			if (mc.joinMemberShip(id, m)) {
				System.out.println("성공적으로 회원가입 완료하였습니다.");
				break;
			} else {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			}
		}
	}
	
	
	public void login() {
		do {
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String pw = sc.next();
			
			if (mc.login(id, pw)==null) {
				System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
			} else {
				System.out.println(mc.login(id, pw)+"님, 환영합니다!");
				memberMenu();
				break;
			}
		} while (true);
	}
	
	
	public void changePassword() {
		while (true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String pw = sc.next();
			System.out.print("변경할 비밀번호 : ");
			String modifiedPw = sc.next();
			
			if(mc.changerPassword(id, pw, modifiedPw)) {
				System.out.println("비밀번호 변경에 성공했습니다.");
				break;
			} else {
				System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");
			}
		}
	}
	
	
	public void changeName() {
		while (true) {
			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String pw = sc.next();
			
			if(mc.login(id, pw)==null) {
				continue;
				
			} else {
				System.out.println("현재 설정된 이름 : "+mc.login(id, pw));
				
				System.out.print("변경할 이름 : ");
				mc.changeName(id, sc.next());
				System.out.println("이름 변경에 성공하였습니다.");
				break;
			}
		}
	}
	
	
	public void sameName() {
		System.out.print("검색할 이름 : ");
		Set entrySet = mc.sameName(sc.next()).entrySet();
		Iterator it = entrySet.iterator();
		
		while (it.hasNext()) {
			Map.Entry<String, String> e = (Map.Entry<String, String>)it.next();
			System.out.println(e.getValue()+"-"+e.getKey());
		}
	}

}
