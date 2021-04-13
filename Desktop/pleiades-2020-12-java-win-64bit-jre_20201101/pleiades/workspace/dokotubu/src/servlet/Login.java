package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginCheckLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���N�G�X�g�p�����[�^�̎擾
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//Userインスタンスを作成
		User user = new User(name, pass);
		
		//���O�C������
		LoginCheckLogic lcl = new LoginCheckLogic();
		boolean check = lcl.execute(user);

		//���O�C������
		if(check == true) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}else {
			request.setAttribute("errorMesage1", "アカウントが存在していないか、ID・パスワードが違います");
		}
		

		//���O�C����ʂɃt�H���[�h
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
	}

}
