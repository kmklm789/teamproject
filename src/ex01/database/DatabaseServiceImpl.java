package ex01.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ex01.memberdto.MemberDTO;

public class DatabaseServiceImpl implements DatabaseService{
	//String url = "jdbc:oracle:thin:@210.108.48.214:1521:xe";
	String url = "jdbc:oracle:thin:@182.172.201.56:1521:xe";
	String id = "team5"; //jsp
	String pwd = "1004";  //1234
	
	public DatabaseServiceImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public int saveMember( MemberDTO dto ) {
		String sql = 
			"insert into user_info(id,pwd,name,p_num) values(?,?,?,?)";
		int result = 0;
		try {
			
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getP_num());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public String loginCheck(String userId) {
		String sql = "select pwd from user_info where id='"+userId+"'";
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getString("pwd");
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}
		
		public String loginCheck1(String userId, String username, String userp_num) {
			String sql = "select pwd from user_info where id=? and name=? and p_num=?";
			try {
				Connection con = DriverManager.getConnection(url,id,pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,userId);
				ps.setString(2,username);
				ps.setString(3,userp_num);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
					return rs.getString("pwd");
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;

	}
		public String loginCheck2(String username, String userp_num) {
			String sql = "select id from user_info where name=? and p_num=?";
			try {
				Connection con = DriverManager.getConnection(url,id,pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,username);
				ps.setString(2,userp_num);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
					return rs.getString("id");
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;

	}


}









