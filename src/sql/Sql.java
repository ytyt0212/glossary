package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sql {
	String sqlwords = null;
	String sqltext = null;
	String sqlCategory = null;

	public String sql(String sqlStr) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/oop?serverTimezone=JST", "root",
					"root");
			Statement stmt = con.createStatement();

			ResultSet rs = null;

			rs = stmt.executeQuery(sqlStr);

			while (rs.next()) {
				if (sqlStr.contains("select words")) {
					sqlwords = rs.getString("words");
				} else if (sqlStr.contains("select text")) {
					sqltext = rs.getString("text");
				} else if (sqlStr.contains("select category_name")) {
					sqlCategory = rs.getString("category_name");
				}
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
			} else {
				return "参照できません";
			}

		} catch (ClassNotFoundException e) {
			return "error" + e;

		} catch (Exception e) {
			return "error" + e;

		}
	}

}
