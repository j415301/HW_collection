package com.kh.practice.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import com.kh.practice.set.model.vo.Lottery;

public class LotteryController {
	
	private HashSet lottery = new HashSet();
	private HashSet<Lottery> win = new HashSet();
	
	
	public boolean insertObject(Lottery l) {
		if (!lottery.contains(l)) {
			lottery.add(l);
			return true;
		} return false;
		
	}
	
	
	public boolean deleteObject(Lottery l) {
		if (lottery.remove(l) && win!=null) {
			win.remove(l);
			return true;
		} return false;
	}
	
	
	public HashSet winObject() {
//		ArrayList list = new ArrayList(lottery);
//		ArrayList <Integer>num = new ArrayList();
//		
//		while (num.size()!=4) {
//			num.add((int)(Math.random()*lottery.size()));
//			num = new ArrayList(new HashSet(num));
//		}//num���� lottery�� �ε��� �� ������ ���� 4���� �̰�
//		
//		for (int i=0 ; i<num.size() ; i++) {
//			win.add(list.get(num.get(i)));
//		}//�� �ε����� �ش��ϴ� �� 4���� list�� �ε����� �Ͽ� win�� ����
//		
//		return win;
		Iterator<Lottery> it = lottery.iterator();
		ArrayList<Lottery> temp = new ArrayList<>();
		
			while(it.hasNext()) {
				temp.add(it.next());
			}
			
			if(temp.size() >= 4) {
				for(int i=0; i<temp.size(); i++) {
					if(win.size()<4) {
						win.add(temp.get(i));
					}
				}
			}
			
			return (HashSet<Lottery>) win;
	}
	
	
	public TreeSet sortedWinObject() {
		winObject();
		
//		ArrayList <Lottery> winList = new ArrayList(win);
//		Collections.sort(winList, new SortedLottery());
//		System.out.println(winList);

		TreeSet <Lottery> winTree = new TreeSet(win);
		
		//TreeSet <Lottery> winTree = new TreeSet<Lottery>();//ClassCasTException
		//Iterator <Lottery> it = winList.iterator();
		//if (it.hasNext()) {
		//	winTree.add(it.next());
		//}

		return winTree;
	}
	
	
	public boolean searchWinner(Lottery l) {
		if (win.contains(l)) {
			return true;
		} return false;
	}

}
