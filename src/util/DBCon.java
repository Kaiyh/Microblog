package util;

import java.sql.*;

public class DBCon {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/weibo";
		String user = "wukai";
		String psw = "wukai";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, psw);
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}
