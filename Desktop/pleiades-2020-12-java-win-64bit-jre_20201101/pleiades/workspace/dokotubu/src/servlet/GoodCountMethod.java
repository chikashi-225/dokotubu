package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Count;
import model.GetGoodCountLogic;
import model.PostGoodCountLogic;
import model.User;

/**
 * Servlet implementation class GoodCountMethod
 */
@WebServlet("/GoodCountMethod")
public class GoodCountMethod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//countListを取得しリクエストスコープに保存
		GetGoodCountLogic getGoodCountLogic = new GetGoodCountLogic();
		List<Count> countList = getGoodCountLogic.execute();
		request.setAttribute("countList", countList);
		
		//ログインしているか確認するため
		//ユーザ情報をセクションスコープから取得
		HttpSession session = request.getSession();
		User loginUser = (User) request.getAttribute("loginUser");
		
		if(loginUser == null) {
			response.sendRedirect("/dokotubu/");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String good = request.getParameter("1");
		
		//DBのCOUNTを更新
		PostGoodCountLogic postGoodCountLogic = new PostGoodCountLogic();
		postGoodCountLogic.execute();
		
		//countListをリクエストスコープに保存
		GetGoodCountLogic getGoodCountLogic = new GetGoodCountLogic();
		List<Count> countList = getGoodCountLogic.execute();
		request.setAttribute("countList", countList);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
