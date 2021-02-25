package com.kh.practice.set.view;

import java.util.Iterator;
import java.util.Scanner;

import com.kh.practice.set.controller.LotteryController;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryMenu {
	
	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();
	
	
	public void mainMenu() {
		System.out.println("========== KH ��÷ ���α׷� ==========");
		
		while (true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. ��÷ ��� �߰�");
			System.out.println("2. ��÷ ��� ����");
			System.out.println("3. ��÷ ��� Ȯ��");
			System.out.println("4. ���ĵ� ��÷ ��� Ȯ��");
			System.out.println("5. ��÷ ��� �˻�");
			System.out.println("9. ����");
			System.out.println();
			System.out.print("�޴� ��ȣ ���� : ");
			
			switch (sc.nextInt()) {
				case 1: insertObject(); break;
				case 2: deleteObject(); break;
				case 3: winObject(); break;
				case 4: sortedWinObject(); break;
				case 5: searchWinner(); break;
				case 9: System.out.println("���α׷� ����"); return;
				default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	
	public void insertObject() {
		int count = 0;
		System.out.print("�߰��� ��÷ ��� �� : ");
		int num = sc.nextInt();
		
		for (int i=0 ; i<num ; i++) {
			System.out.print("�̸� : ");
			String name = sc.next();
			System.out.print("�޴��� ��ȣ('-'����) : ");
			String phone = sc.next();
			Lottery l = new Lottery(name, phone);
			System.out.println();
			
			if(lc.insertObject(l)) {
				count++;
				System.out.println(count+"�� �߰� �Ϸ�Ǿ����ϴ�.");
			} else System.out.println("�ߺ��� ����Դϴ�. �ٽ� �Է��ϼ���.");
			System.out.println();
		}
	}
	
	
	public void deleteObject() {
		System.out.println("������ ����� �̸��� �ڵ��� ��ȣ�� �Է��ϼ���.");
		
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("�޴��� ��ȣ('-'����) : ");
		String phone = sc.next();
		Lottery l = new Lottery(name, phone);
		
		if (lc.deleteObject(l)) System.out.println("���� �Ϸ� �Ǿ����ϴ�.");
		else System.out.println("�������� �ʴ� ����Դϴ�.");
	}
	
	
	public void winObject() {
		System.out.println(lc.winObject());
	}
	
	
	public void sortedWinObject() {
		Iterator <Lottery> it = lc.sortedWinObject().iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	
	public void searchWinner() {
		System.out.println("�˻��� ����� �̸��� �ڵ��� ��ȣ�� �Է��ϼ���.");
		
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("�޴��� ��ȣ('-'����) : ");
		String phone = sc.next();
		
		Lottery l = new Lottery(name, phone);
		if (lc.searchWinner(l)) System.out.println("�����մϴ�. ��÷ ��Ͽ� �����մϴ�.");
		else System.out.println("��Ÿ������ ��÷ ��Ͽ� �������� �ʽ��ϴ�.");
	}

}
