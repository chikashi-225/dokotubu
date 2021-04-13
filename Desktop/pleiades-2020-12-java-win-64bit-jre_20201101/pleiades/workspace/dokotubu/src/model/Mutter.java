package model;

import java.io.Serializable;

public class Mutter implements Serializable {
	private int id;           //id
	private String userName;  //ユーザー名
	private String text;      //つぶやき
	private int good; //good

	public Mutter() {}
	public Mutter(String name, String text) {
		this.userName = name;
		this.text = text;
	}
	public Mutter(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}
	public Mutter(String userName, String text, int good) {
		this.userName = userName;
		this.text = text;
		this.good = good;
	}
	public Mutter(int id, String userName, String text, int good) {
		this.id = id;
		this.userName = userName;
		this.text = text;
		this.good = good;
	}

	public int getId() { return id;}
	public String getUserName() { return userName;}
	public String getText() { return text;}
	public int getGood() { return good;}
	public void setGood(int good) {
		this.good = good;
	}
}
