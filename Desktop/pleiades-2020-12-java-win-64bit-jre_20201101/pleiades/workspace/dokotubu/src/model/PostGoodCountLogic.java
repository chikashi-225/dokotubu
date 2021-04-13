package model;

import java.io.Serializable;

import dao.GoodCountDAO;

public class PostGoodCountLogic implements Serializable {
	public void execute(Count count) {
		GoodCountDAO gcd = new GoodCountDAO();
		gcd.addCount(count);
	}
	
	public void execute() {
		GoodCountDAO gcd = new GoodCountDAO();
		gcd.createCount();
	}
}
