package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Sql {
	String sqlwords = null;
	String sqltext = null;
	String sqlCategory = null;
	int count;

	public String sql(String sqlStr) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/oop?serverTimezone=JST", "root",
					"root");
			Statement stmt = con.createStatement();
			int cnt ;
			ResultSet rs = null;
			if (sqlStr.contains("select")) {
				sqlwords = null;
				sqltext = null;
				sqlCategory = null;
				rs = stmt.executeQuery(sqlStr);
			}else if(sqlStr.contains("update") || sqlStr.contains("insert") || sqlStr.contains("delete")) {
				try {
				cnt = stmt.executeUpdate(sqlStr);
				con.commit();
				}catch(Exception e) {
					con.rollback();
				}
			}

			while (rs.next()) {
				count =0;
				if (sqlStr.contains("select words") && rs != null) {
					sqlwords = rs.getString("words");
				} else if (sqlStr.contains("select text") && rs != null) {
					sqltext = rs.getString("text");
				} else if (sqlStr.contains("select category_name") && rs != null) {
					sqlCategory = rs.getString("category_name");
				}
				count++;
			}
			

			rs.close();
			stmt.close();
			con.close();

			if (sqlStr.contains("select words")) {
				return sqlwords;				
			} else if (sqlStr.contains("select text")) {
				return sqltext;
			} else if (sqlStr.contains("select category_name")) {
				return sqlCategory;
			} else if (sqlStr.contains("update")) {
				return "更新しました";
			}else if (sqlStr.contains("insert")) {
				return "登録しました";
			} else {
				return null;
			}

		} catch (ClassNotFoundException e) {
			return "error" + e;

		} catch (Exception e) {
			return "error" + e;

		}
	}

}
