package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	
	private List <Music> list = new ArrayList();
	
	
	public int addList(Music music) {
		list.add(music);
		return 1;
	}
	
	
	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;
	}
	
	
	public List printAll() {
		return list;
	}
	
	
	public Music searchMusic (String title) {
		for (int i=0 ; i<list.size() ; i++) {
			if(list.get(i).getTitle().equals(title)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	
	public Music removeMusic (String title) {
		for (int i=0 ; i<list.size() ; i++) {
			if(list.get(i).getTitle().equals(title)) {
				Music m = list.get(i);
				list.remove(i);
				return m;//nullpointerException 나느 거 아님? 
			}
		}
		return null;
	}
	
	
	public Music setMusic (String title, Music music) {
		for (int i=0 ; i<list.size() ; i++) {
			if(list.get(i).getTitle().equals(title)) {
				List <Music> m = new ArrayList();
				m.add(list.get(i));
				list.set(i, music);
				return m.get(0);//set하기 전 객체를 저장해서 리턴했는데 왜 바뀐 후 값이 리턴될까?
								//값 자체가 아닌 주소값을 넘겨주는 것이기 때문에, 결국은 그 주소에서 값이 수정되고 수정된 값이 리턴될 수 밖에 없음
								//이를 해결하려면 깊은 복사를 통해 넘겨줘야 함
			}
		}
		return null;
	}
	
	
	public int ascTitle() {
		Collections.sort(list, new AscTitle());
		return 1;
	}
	
	
	public int descSinger() {
		Collections.sort(list);
		return 1;
	}

}
