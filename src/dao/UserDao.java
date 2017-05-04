package dao;

import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import util.*;

public class UserDao {
	
	private static Connection conn = null;
	
	public static boolean checkRegister(String userName, String userPsw) {
		conn = DBCon.getConnection();
		
		boolean flag = false;
		try {
			String sql = "select * from table_user where userName=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			int cnt = 0;
			while (rs.next()) {
				cnt++;
			}
			
			if (cnt == 0) {//数据库表中不存在当前用户名，可以插入数据
				flag = true;
				sql = "insert into table_user values(?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, userPsw);
				ps.setString(3, "");
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	public static boolean checkLogin(String userName, String userPsw) {
		conn = DBCon.getConnection();
		
		boolean flag = false;
		try {
			String sql = "select * from table_user where userName=? and userPsw=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPsw);
			ResultSet rs = ps.executeQuery();
			
			int cnt = 0;
			while (rs.next()) {
				cnt++;
			}

			if (cnt > 0) {//查找到符合条件的元组
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}
	
	public static void addWeibo(String userName, String userWeibo) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		
		conn = DBCon.getConnection();
		
		try {
			String sql = "select userWeibo from table_user where userName=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			String weibo = "";
			while (rs.next()) {
				weibo += rs.getString(1);
			}
			weibo += "【" + time + "】" + userWeibo + "<br><br>";
			
			sql = "update table_user set userWeibo=? where userName=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, weibo);
			ps.setString(2, userName);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String showWeibo(String userName) {
		conn = DBCon.getConnection();
		String weibo = "";
		
		try {
			String sql = "select userWeibo from table_user where userName=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				weibo += rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return weibo;
	}
	
	public static Vector<String> showLike(String userName, String ID) {
		conn = DBCon.getConnection();
		Vector<String> ve = new Vector<String>();
		
		for (int i = 0; i < userName.length(); i++) {
			try {
				String sql = "select userName from table_user where userName like ? and userName != ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				String ch = "%" + userName.charAt(i) + "%";
				ps.setString(1, ch);
				ps.setString(2, ID);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String tmp = rs.getString(1);
					System.out.println(tmp);
					ve.add(tmp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ve;
	}
	
	
	public static int addFans(String user1, String user2) {
		conn = DBCon.getConnection();
		
		try {
			//处理已经关注过的
			String sql = "select * from table_fans where user1=? and user2=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user1);
			ps.setString(2, user2);
			ResultSet rs = ps.executeQuery();
			int cnt = 0;
			while (rs.next()) {
				cnt++;
			}
			if (cnt != 0) {
				return 1;
			}
			
			//处理搜索自己的
			if (user1.equals(user2)) {
				return 1;
			}
			
			//处理正确的关注操作
			sql = "select * from table_user where userName=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user1);
			rs = ps.executeQuery();
			cnt = 0;
			while (rs.next()) {
				cnt++;
			}
			if (cnt > 0) {
				sql = "insert into table_fans values(?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, user1);
				ps.setString(2, user2);
				ps.executeUpdate();
				return 2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//处理模糊查询
		Vector<String> ve = showLike(user1, user2);
		if (ve.size() > 0) {
			return 3;
		}
		return 1;
	}
	
	public static void noFans(String user1, String user2) {
		conn = DBCon.getConnection();
		
		try {
			String sql = "delete from table_fans where user1=? and user2=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user1);
			ps.setString(2, user2);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Vector<String> showAttens(String userName) {
		conn = DBCon.getConnection();
		Vector<String> ve = new Vector<String>();
		
		try {
			String sql = "select user1 from table_fans where user2=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String tmp = rs.getString(1);
				ve.add(tmp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ve;
	}
	
	public static Vector<String> showFans(String userName) {
		conn = DBCon.getConnection();
		Vector<String> ve = new Vector<String>();
		
		try {
			String sql = "select user2 from table_fans where user1=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String tmp = rs.getString(1);
				ve.add(tmp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ve;
	}
	
}
