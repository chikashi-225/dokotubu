package model;

import dao.AccountDAO;

public class LoginCheckLogic {
	public boolean execute(User user) {
		AccountDAO dao = new AccountDAO();
		User user1 = dao.findByUser(user);
		if(user1 == null) {
			return false;
		}else {
			return true;
		}
	}

}
