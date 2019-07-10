package test;

import java.sql.*;

public class Sql_test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String msg = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/oop?serverTimezone=JST", "root",
					"root");
			Statement stmt = con.createStatement();

			PreparedStatement pstmt = null;
			ResultSet rs = null;

			int id = 1;

			pstmt = con.prepareStatement("select words from glossary where category_id = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("words"));

			}
			rs.close();
			stmt.close();
			con.close();

		} catch (ClassNotFoundException e) {
			msg = "error";
			System.out.println(msg + e);
		} catch (Exception e) {
			msg = "error";
			System.out.println(msg + e);
		}
	}

}
