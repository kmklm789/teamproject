package ex01.friendList.friendDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ex01.friendList.checkdto.CheckDTO;
import ex01.memberdto.MemberDTODH;

public class DbFriendImpl implements DbFriend{
	String url = "jdbc:oracle:thin:@182.172.201.56:1521:xe";
	String id = "team5";
	String pwd = "1004";
	ArrayList<String> friend = new ArrayList<String>();
	
	public DbFriendImpl() {
		System.out.println("연결되었습니다");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
/*
	@Override
	public int saveMember(MemberDTO a) {
		String sql =
				"insert into member(id) values(?)";
		int result = 0;
		/*try {
		Connection con = DriverManager.getConnection(url,id);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		result = ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}*/

	@Override
	public String loginCheck(String userId) {
		String sql= "select id from user_info where id='"+userId+"'";
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getString("id");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int saveMember(CheckDTO dto) {
		String sql = 
				"insert into friend_list(my_id,friend_id) values(?,?)";
		int result = 0;
		try {
			
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMy_id()); //여기서 데이터베이스에 저장
			ps.setString(2, dto.getFriend_id());

			result = ps.executeUpdate(); //성공을 하면 결과 1이 나올것이고 아니면 catch로 넘어감

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int saveMember(MemberDTODH a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<String> dbClass(String myId) {
		String sql= "select friend_id from friend_list where my_id = '"+myId+"'";
		try {
			Connection con = DriverManager.getConnection(url,id,pwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				friend.add(rs.getString("friend_id"));
				System.out.println(rs.getString("friend_id"));
			}
			System.out.println("==========================");
			return friend;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
