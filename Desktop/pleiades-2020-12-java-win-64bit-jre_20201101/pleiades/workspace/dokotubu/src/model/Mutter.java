package model;

import java.io.Serializable;

public class Mutter implements Serializable {
	private int id;           //id
	private String userName;  //���[�U�[��
	private String text;      //�Ԃ₫���e

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

	public int getId() { return id;}
	public String getUserName() { return userName;}
	public String getText() { return text;}

}
