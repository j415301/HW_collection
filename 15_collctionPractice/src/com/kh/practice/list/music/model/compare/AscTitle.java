package com.kh.practice.list.music.model.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;

public class AscTitle implements Comparator <Music>{
	
	public int compare (Music m1, Music m2) {
		if (m1.getTitle().compareTo(m2.getTitle())==0) {
			return m1.getSinger().compareTo(m2.getSinger());
		}
		return m1.getTitle().compareTo(m2.getTitle());
	}

}
