package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	//�f�[�^�x�[�X�ڑ��Ɏg�p������
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/dokotubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<>();

		//MUTTERからつぶやきを取得
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "SELECT ID, NAME, TEXT, GOOD FROM MUTTER ORDER BY ID DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//SELECT文を実行
			ResultSet rs = pstmt.executeQuery();

			//SELECTからつぶやきを取得
			while(rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				int good = rs.getInt("GOOD");
				Mutter mutter = new Mutter(id, userName, text, good);
				mutterList.add(mutter);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return mutterList;
		}
		return mutterList;
	}

	public boolean create(Mutter mutter) {
		//つぶやきをMUTTERに保存
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//INSERTの準備
			String sql = "INSERT INTO MUTTER (NAME, TEXT) VALUES(?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//INSERTを完成させる
			pstmt.setString(1, mutter.getUserName());
			pstmt.setString(2, mutter.getText());

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
