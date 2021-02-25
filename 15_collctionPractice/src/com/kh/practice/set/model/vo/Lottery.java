package com.kh.practice.set.model.vo;

public class Lottery implements Comparable<Lottery> {
	
	private String name;
	private String phone;
	
	
	public Lottery() {
		// TODO Auto-generated constructor stub
	}


	public Lottery(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return name + "(" + phone + ")";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lottery other = (Lottery) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}


	@Override
	//이름 오름, 번호 오름
	public int compareTo(Lottery o) {
		// TODO Auto-generated method stub
		if (name.equals(o.getName())) {
			return phone.compareTo(o.phone);
		}
		return name.compareTo(o.name);
	}

	
	
}
