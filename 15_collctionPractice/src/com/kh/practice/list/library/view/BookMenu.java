package com.kh.practice.list.library.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {
	
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	
	
	public void mainMenu() {
		System.out.println("== Welcome KH Library ==");
		System.out.println();
		
		while (true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. �� ���� �߰�");
			System.out.println("2. ���� ��ü ��ȸ");
			System.out.println("3. ���� �˻� ��ȸ");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� �� �������� ����");
			System.out.println("9. ����");
			System.out.println();
			
			System.out.print("�޴� ��ȣ ���� : ");
			switch (sc.nextInt()) {
				case 1: insertBook(); break;
				case 2: selectList(); break;
				case 3: searchBook(); break;
				case 4: deleteBook(); break;
				case 5: ascBook(); break;
				case 9: System.out.println("���α׷��� �����մϴ�."); return;
				default: System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	
	public void insertBook() {
		System.out.println("===== �� ���� �߰� =====");
		System.out.println("å ������ �Է����ּ���.");
		sc.nextLine();
		
		String category = "";
		
		System.out.print("������ : ");
		String title = sc.nextLine();
		
		System.out.print("���ڸ� : ");
		String author = sc.nextLine();
		
		System.out.print("�帣(1. �ι� / 2. ���� / 3. �ܱ��� / 4. ��Ÿ) : ");
		switch (sc.nextInt()) {
			case 1: category = "�ι�";
			case 2: category = "�ڿ�����";
			case 3: category = "�Ƿ�";
			case 4: category = "��Ÿ";
		}
		
		System.out.print("���� : ");
		int price = sc.nextInt();
		
		Book b = new Book(title, author, category, price);
		bc.insertBook(b);
		
		System.out.println();
	}
	
	
	public void selectList() {
		System.out.println("===== ���� ��ü ��ȸ =====");
		
		ArrayList<Book> bookList = bc.selectList();
		
		if (bookList.isEmpty()) {
			System.out.println("�����ϴ� ������ �����ϴ�.");
		} else {
			for (int i=0 ; i<bookList.size() ; i++) {
				System.out.println(bookList.get(i));
			}
		}
		
		System.out.println();
	}
	
	
	public void searchBook() {
		System.out.println("===== ���� �˻� =====");
		sc.nextLine();
		
		System.out.print("�˻� Ű���� : ");
		String keyword = sc.nextLine();
		
		ArrayList<Book> searchList = bc.searchBook(keyword);
		
		if(searchList.isEmpty()) {
			System.out.println("�˻� ����� �����ϴ�.");
		} else {
			for (int i=0 ; i<searchList.size() ; i++) {
				System.out.println(searchList.get(i));
			}
		}
		
		System.out.println();
	}
	
	
	public void deleteBook() {
		System.out.println("===== ���� ���� =====");
		sc.nextLine();
		
		System.out.print("������ ������ : ");
		String title = sc.nextLine();
		System.out.print("������ ���ڸ� : ");
		String author = sc.nextLine();
		
		Book remove = bc.deleteBook(title, author);
		
		if (remove!=null) {
			System.out.println("���������� �����Ǿ����ϴ�.");
		} else {
			System.out.println("������ ������ ã�� ���߽��ϴ�.");
		}
		
		System.out.println();
	}
	
	
	public void ascBook() {
		if (bc.ascBook()==1) {
			System.out.println("���Ŀ� �����Ͽ����ϴ�.");
		} else {
			System.out.println("���Ŀ� �����Ͽ����ϴ�.");
		}
	}

}
