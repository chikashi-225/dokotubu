package model;

import dao.MutterDAO;

public class PostMutter {
	public void execute(Mutter mutter) {
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
	}

}
