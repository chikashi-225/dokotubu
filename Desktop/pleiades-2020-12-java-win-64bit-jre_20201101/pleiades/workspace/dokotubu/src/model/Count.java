package model;

import java.io.Serializable;

public class Count implements Serializable {
	private int good;   //いいねの数
	private int id;    //id
	
	public Count() {
		good = 0;
		id = 0;
	}
	
	public Count(int good) {
		this.good = good;
	}
	
	public Count(int good, int id) {
		this.good = good;
		this.id = id;
	}
	
	public int getGood() { return good;}
	public void setLike(int good) {
		this.good = good;
	}
	
	public int getId() { return id;}
	public void setId(int id) {
		this.id = id;
	}
}
