package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import gui.IndexPage2;

public class Sql {
	String sqlwords = null;
	String sqltext = null;
	String sqlCategory = null;
	int count;

	public String sql(String sqlStr) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/oop?serverTimezone=JST", "root",
					"root");
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			int cnt;
			ResultSet rs = null;
			// SELECT文の処理
			if (sqlStr.contains("select")) {
				sqlwords = null;
				sqltext = null;
				sqlCategory = null;
				rs = stmt.executeQuery(sqlStr);
				// UPDATE、INSERT、DELETE文の処理
			} else if (sqlStr.contains("update") || sqlStr.contains("insert") || sqlStr.contains("delete")) {
				try {
					cnt = stmt.executeUpdate(sqlStr);
					con.commit();
				} catch (Exception e) {
					con.rollback();
					return "error";
				}
			}
			// 結果のセット
			while (rs.next()) {
				count = 0;
				if (sqlStr.contains("select words") && rs != null) {
					sqlwords = rs.getString("words");
					IndexPage2.listWord.add(sqlwords);
				} else if (sqlStr.contains("select text") && rs != null) {
					sqltext = rs.getString("text");
				} else if (sqlStr.contains("select category_name") && rs != null) {
					sqlCategory = rs.getString("category_name");
					IndexPage2.listCategory.add(sqlCategory);
				}
				count++;

			}

			rs.close();
			stmt.close();
			con.close();

			// 結果の返却
			if (sqlStr.contains("select words")) {
				return sqlwords;
			} else if (sqlStr.contains("select text")) {
				return sqltext;
			} else if (sqlStr.contains("select category_name")) {
				return sqlCategory;
			} else if (sqlStr.contains("update")) {
				return "更新しました";
			} else if (sqlStr.contains("insert")) {
				return "登録しました";
			} else if (sqlStr.contains("delete")) {

				return "削除しました";
			} else {
				return "error";
			}

		} catch (ClassNotFoundException e) {
			return "error";

		} catch (Exception e) {
			return "error";

		}
	}

}
