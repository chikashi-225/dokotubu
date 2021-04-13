package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegistAccountLogic;
import model.User;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���N�G�X�g�p�����[�^���擾
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//User�C���X�^���X�𐶐�
		User user = new User(name, pass);

		//RegistAccountLogic���Ăяo��
		RegistAccountLogic ral = new RegistAccountLogic();

		//�A�J�E���g�o�^����
		boolean gouhi = ral.execute(user);
		if(gouhi == true) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}else {
			request.setAttribute("errorMasege2", "アカウントが存在しているか、ID・パスワードが間違っています");
		}

		//�A�J�E���g�o�^��ʂփt�H���[�h
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registResult.jsp");
		dispatcher.forward(request, response);
	}

}
