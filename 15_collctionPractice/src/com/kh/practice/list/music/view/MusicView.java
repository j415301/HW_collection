package com.kh.practice.list.music.view;

import java.util.List;
import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	
	public void mainMenu() {
		while (true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. ������ ��ġ�� �� �߰�");
			System.out.println("2. ù ��ġ�� �� �߰�");
			System.out.println("3. ��ü �� ��� ���");
			System.out.println("4. Ư�� �� �˻�");
			System.out.println("5. Ư�� �� ����");
			System.out.println("6. Ư�� �� ���� ����");
			System.out.println("7. ��� �������� ����");
			System.out.println("8. ������ �������� ����");
			System.out.println("9. ����");
			System.out.println();
			
			System.out.print("�޴� ��ȣ ���� : ");
			switch (sc.nextInt()) {
				case 1: addList(); break;
				case 2: addAtZero(); break;
				case 3: printAll(); break;
				case 4: searchMusic(); break;
				case 5: removeMusic(); break;
				case 6: setMusic(); break;
				case 7: ascTitle(); break;
				case 8: descSinger(); break;
				case 9: System.out.println("����"); return;
			}
		}
	}
	
	
	public void addList() {
		sc.nextLine();
		System.out.println("****** ������ ��ġ�� �� �߰� ******");
		
		System.out.print("��� : ");
		String title = sc.nextLine();
		System.out.print("������ : ");
		String singer = sc.nextLine();
		
		Music m = new Music(title, singer);
		
		if (mc.addList(m)==1) System.out.println("�߰� ����");
		else System.out.println("�߰� ����");
		System.out.println();
	}
	
	
	public void addAtZero() {
		sc.nextLine();
		System.out.println("****** ù ��ġ�� �� �߰� ******");
		
		System.out.print("��� : ");
		String title = sc.nextLine();
		System.out.print("������ : ");
		String singer = sc.nextLine();
		
		Music m = new Music(title, singer);
		
		if (mc.addList(m)==1) System.out.println("�߰� ����");
		else System.out.println("�߰� ����");
		System.out.println();
	}
	
	
	public void printAll() {
		System.out.println("****** ��ü �� ��� ��� ******");
		
		System.out.println(mc.printAll());
		
		System.out.println();
	}
	
	
	public void searchMusic() {
		sc.nextLine();
		System.out.println("****** Ư�� �� �˻� ******");
		
		System.out.print("�˻��� ��� : ");
		Music m = mc.searchMusic(sc.nextLine());
		
		if (m!=null) System.out.println(m.getSinger()+" - "+m.getTitle());
		else System.out.println("�˻��� ���� �����ϴ�.");
		System.out.println();
	}
	
	
	public void removeMusic() {
		sc.nextLine();
		System.out.println("****** Ư�� �� ���� ******");
		
		System.out.print("������ ��� : ");
		Music m = mc.removeMusic(sc.nextLine());
		
		if (m!=null) System.out.println(m.getSinger()+" - "+m.getTitle()+"��(��) �����߽��ϴ�.");
		else System.out.println("������ ���� �����ϴ�.");
		System.out.println();
	}
	
	
	public void setMusic() {
		sc.nextLine();
		System.out.println("****** Ư�� �� ���� ���� ******");
		
		System.out.print("�˻��� ��� : ");
		String title = sc.nextLine();
		System.out.print("������ ��� : ");
		String t = sc.nextLine();
		System.out.print("������ ������ : ");
		String s = sc.nextLine();
		
		Music m = new Music(t, s);
		
		if (mc.setMusic(title, m)==null) System.out.println("������ ���� �����ϴ�.");
		else System.out.println(m.getSinger()+" - "+m.getTitle()+"�� ���� ����Ǿ����ϴ�.");
		System.out.println();
	}
	
	
	public void ascTitle() {
		System.out.println("****** �� �� �������� ���� ******");
		
		if (mc.ascTitle()==1) System.out.println("���� ����");
		else System.out.println("���� ����");
		System.out.println();
	}
	
	
	public void descSinger() {
		System.out.println("****** ���� �� �������� ���� ******");
		
		if (mc.descSinger()==1) System.out.println("���� ����");
		else System.out.println("���� ����");
		System.out.println();
	}

}
