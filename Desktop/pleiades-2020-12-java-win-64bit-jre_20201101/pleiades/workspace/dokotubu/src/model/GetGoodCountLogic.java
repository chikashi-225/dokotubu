package model;

import java.io.Serializable;
import java.util.List;

import dao.GoodCountDAO;

public class GetGoodCountLogic implements Serializable{
	public List<Count> execute() {
		GoodCountDAO gcd = new GoodCountDAO();
		List<Count> countList = gcd.findAll();
		return countList;
	}
}
