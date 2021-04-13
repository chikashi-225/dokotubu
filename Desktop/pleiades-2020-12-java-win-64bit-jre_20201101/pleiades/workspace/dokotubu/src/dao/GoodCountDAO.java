package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Count;

public class GoodCountDAO {
	public final String JDBC_URL = "jdbc:h2:tcp://localhost/~/dokotubu";
	public final String DB_USER = "sa";
	public final String DB_PASS = "";
	
	List<Count> countList = new ArrayList<>();
	
	public List<Count> findAll() {
		//GOODCOUNTからgoodを取得
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "SELECT ID, COUNT FROM GOODCOUNT ORDER BY ID DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//SELECT文を実行
			ResultSet rs = pstmt.executeQuery();
			
			//SELECT文からgoodを取得
			while(rs.next()) {
				int id = rs.getInt("ID");
				int like = rs.getInt("COUNT");
				Count count = new Count(like, id) ;
				countList.add(count);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return countList;
		}
		return countList;
	}
	
	public boolean createCount() {//つぶやき投稿時に実行
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//INSERT文を準備
			String sql = "INSERT INTO GOODCOUNT (COUNT) VALUES(?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//INSERT文を完成させる
			pstmt.setInt(1, 0);
			
			//INSERT文を送る
			int result = pstmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addCount(Count count) {//goodボタンクリック時に実行
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//INSERT文を準備
			String sql = "INSERT INTO GOODCOUNT (COUNT, ID) VALUES(?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//INSERT文を完成させる
			pstmt.setInt(1, count.getGood());
			pstmt.setInt(2, count.getId());
			
			//INSERT文を送る
			int result = pstmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	

}
