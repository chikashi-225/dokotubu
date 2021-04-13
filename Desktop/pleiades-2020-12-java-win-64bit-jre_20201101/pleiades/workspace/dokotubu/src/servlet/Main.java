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
import model.GetMutterListLogic;
import model.Mutter;
import model.PostGoodCountLogic;
import model.PostMutter;
import model.User;


/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//つぶやきリストを取得してリクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		GetGoodCountLogic getGoodCountLogic = new GetGoodCountLogic();
		List<Count> countList = getGoodCountLogic.execute();
		request.setAttribute("mutterList", mutterList);
		request.setAttribute("countList", countList);

		//ログインしているか確認するため
		//セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if(loginUser == null) { //ログインしていなかった場合
			//ログイン画面に戻る
			response.sendRedirect("/dokotubu/");
		} else { //ログインしていた場合
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		//入力値チェック
		if(text != null && text.length() != 0) {

			//セッションスコープに保存されているユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");

			//つぶやきをつぶやきリストに追加
			Mutter mutter = new Mutter(loginUser.getName(), text);
			PostMutter postMutter = new PostMutter();
			postMutter.execute(mutter);
			PostGoodCountLogic postGoodCountLogic = new PostGoodCountLogic();
			postGoodCountLogic.execute();

		} else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきを入力してください");
		}

		//つぶやきリストとcountListを取得してリクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		GetGoodCountLogic getGoodCountLogic = new GetGoodCountLogic();
		List<Count> countList = getGoodCountLogic.execute();
		request.setAttribute("mutterList", mutterList);
		request.setAttribute("countList", countList);

		//main.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, respose);

	}

}
