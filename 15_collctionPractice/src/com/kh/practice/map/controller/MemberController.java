package com.kh.practice.map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import com.kh.practice.map.model.vo.Member;

public class MemberController {
	
	private HashMap <String, Member> map = new HashMap<>();
	
	
	public boolean joinMemberShip(String id, Member m) {
		if (!map.containsKey(id)) {
			map.put(id, m);
			return true;
		} return false;
	}
	
	
	public String login(String id, String password) {
		if (map.containsKey(id)) {
			if (map.get(id).getPassword().equals(password)) {
				return map.get(id).getName();
			}
		}
		return null;
	}
	
	
	public boolean changerPassword(String id, String oldPw, String newPw) {
		if(map.containsKey(id) && map.get(id).getPassword().equals(oldPw)) {
			map.get(id).setPassword(newPw);
			return true;
		}
		return false;
	}
	
	
	public void changeName(String id, String newName) {
		map.get(id).setName(newName);
	}
	
	
	public TreeMap sameName(String name) {
		TreeMap tmap = new TreeMap();
		Iterator it = map.keySet().iterator();
		
		while (it.hasNext()) {
			Object key = it.next();
			
			if (map.get(key).getName().equals(name)) {
				tmap.put(key, name);
			}
		}
		
		return tmap;
	}

}
