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
		System.out.println("========== KH ����Ʈ ==========");
		
		while (true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. ȸ������");
			System.out.println("2. �α���");
			System.out.println("3. ���� �̸� ȸ�� ã��");
			System.out.println("9. ����");
			System.out.println();
			
			System.out.print("�޴� ��ȣ ���� : ");
			switch (sc.nextInt()) {
				case 1: joinMembership(); break;
				case 2: login(); memberMenu(); break;
				case 3: sameName(); break;
				case 9: System.out.println("���α׷� ����"); return;
				default: System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	
	public void memberMenu() {
		System.out.println("******* ȸ�� �޴� *******");
		
		System.out.println("1. ��й�ȣ �ٲٱ�");
		System.out.println("2. �̸� �ٲٱ�");
		System.out.println("3. �α׾ƿ�");
		System.out.println();
		
		System.out.print("�޴� ��ȣ ���� : ");
		switch (sc.nextInt()) {
			case 1: changePassword(); break;
			case 2: changeName(); break;
			case 3: System.out.println("�α׾ƿ� �Ǿ����ϴ�."); return;
			default: System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
		}
	}
	
	
	public void joinMembership() {
		while (true) {
			System.out.print("���̵� : ");
			String id = sc.next();
			System.out.print("��й�ȣ : ");
			String pw = sc.next();
			System.out.print("�̸� : ");
			String name = sc.next();
			
			Member m = new Member(pw, name);
			if (mc.joinMemberShip(id, m)) {
				System.out.println("���������� ȸ������ �Ϸ��Ͽ����ϴ�.");
				break;
			} else {
				System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	
	public void login() {
		do {
			System.out.print("���̵� : ");
			String id = sc.next();
			System.out.print("��й�ȣ : ");
			String pw = sc.next();
			
			if (mc.login(id, pw)==null) {
				System.out.println("Ʋ�� ���̵� �Ǵ� ��й�ȣ�Դϴ�. �ٽ� �Է����ּ���.");
			} else {
				System.out.println(mc.login(id, pw)+"��, ȯ���մϴ�!");
				memberMenu();
				break;
			}
		} while (true);
	}
	
	
	public void changePassword() {
		while (true) {
			System.out.print("���̵� : ");
			String id = sc.next();
			System.out.print("��й�ȣ : ");
			String pw = sc.next();
			System.out.print("������ ��й�ȣ : ");
			String modifiedPw = sc.next();
			
			if(mc.changerPassword(id, pw, modifiedPw)) {
				System.out.println("��й�ȣ ���濡 �����߽��ϴ�.");
				break;
			} else {
				System.out.println("��й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	
	public void changeName() {
		while (true) {
			System.out.print("���̵� : ");
			String id = sc.next();
			System.out.print("��й�ȣ : ");
			String pw = sc.next();
			
			if(mc.login(id, pw)==null) {
				continue;
				
			} else {
				System.out.println("���� ������ �̸� : "+mc.login(id, pw));
				
				System.out.print("������ �̸� : ");
				mc.changeName(id, sc.next());
				System.out.println("�̸� ���濡 �����Ͽ����ϴ�.");
				break;
			}
		}
	}
	
	
	public void sameName() {
		System.out.print("�˻��� �̸� : ");
		Set entrySet = mc.sameName(sc.next()).entrySet();
		Iterator it = entrySet.iterator();
		
		while (it.hasNext()) {
			Map.Entry<String, String> e = (Map.Entry<String, String>)it.next();
			System.out.println(e.getValue()+"-"+e.getKey());
		}
	}

}
