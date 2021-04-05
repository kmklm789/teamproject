package ex01.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import ex01.imagedto.ImageDTO;
import ex01.mainPage.diarydto.DiaryDTO;
import ex01.mainPage.profile.Information;
import ex01.mainPage.profile.profiledto.ProfileDTO;
import ex01.memberdto.MemberDTO;
import ex01.visitordto.VisitorDTO;

public class DatabaseServiceImpl implements DatabaseService{
	HashMap<Integer, String> diaryMap = new HashMap<Integer, String>();
	HashMap<Integer, String> visitorMap = new HashMap<Integer, String>();
	HashMap<Integer, String> imageMap = new HashMap<Integer, String>();
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
		public int saveDiary(DiaryDTO diaryDto) {
			String sql = "insert into diary(id, serialNum, content, time) values(?, ?, ?, ?)";
			int result = 0;
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, diaryDto.getId());
				ps.setInt(2, diaryDto.getSerialNum());
				ps.setString(3, diaryDto.getContent());
				ps.setString(4, diaryDto.getTime());
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		public HashMap<Integer, String> showDiary(String userId) {
			String sql = "select serialNum, content, time from diary where id = '" + userId + "'";
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					String time = rs.getString("time");
					String content = time + "\n" + rs.getString("content");
					diaryMap.put(rs.getInt("serialNum"), content);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return diaryMap;
		}
		public int diarySerialNum(String userId) {
			int dsNum = 0;
			String sql = "select serialNum from diary where id = '" + userId + "'";
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					if(dsNum < rs.getInt("serialNum")) {
						dsNum = rs.getInt("serialNum");
					}
				}
				dsNum += 1;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return dsNum;
		}
		
		public int saveVisitor(VisitorDTO visitDto) {
			String sql = "insert into visitor(id, serialNum, content, time) values(?, ?, ?, ?)";
			int result = 0;
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, visitDto.getId());
				ps.setInt(2, visitDto.getSerialNum());
				ps.setString(3, visitDto.getContent());
				ps.setString(4, visitDto.getTime());
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		public HashMap<Integer, String> showVisitor(String userId) {
			String sql = "select serialNum, content, time from visitor where id = '" + userId + "'";
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					String time = rs.getString("time");
					String content = time + "\n" + rs.getString("content");
//					visitorMap.put(rs.getInt("serialNum"), rs.getString("content"));
					visitorMap.put(rs.getInt("serialNum"), content);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return visitorMap;
		}
		public int visitorSerialNum(String userId) {
			int vsNum = 0;
			String sql = "select serialNum from visitor where id = '" + userId + "'";
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					if(vsNum < rs.getInt("serialNum")) {
						vsNum = rs.getInt("serialNum");
					}
				}
				vsNum += 1;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return vsNum;
		}
		public String profileImageShow(String userId) {
			String sql = "select path from profilepath where id = '" + userId + "'";
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getString("path");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public int profileImage(ProfileDTO dto) {
			String sql = "insert into profilepath(id, path) values(?, ?)";
			int result = 0;
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dto.getId());
				ps.setString(2, dto.getPath());
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		public int profileImageUpdate(String userId, String path) {
			String sql = "update profilepath set path = '" + path + "' where id = '" + userId + "'";
			int result = 0;
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps  = con.prepareStatement(sql);
				ps.executeQuery();
				result = ps.executeUpdate();  // select를 제외한 나머지는 update를 씀
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		public int profileImageDelete(String userId) {
			String sql = "delete from profilepath where id = '" + userId + "'";
			int result = 0;
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps  = con.prepareStatement(sql);
				result = ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		public int profileSave(Information info) {
			String sql = "insert into profile(id, name, age, birth, gender, pnum, content) values(?, ?, ?, ?, ?, ?, ?)";
			int result = 0;
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, info.getId());
				ps.setString(2, info.getName());
				ps.setString(3, info.getAge());
				ps.setString(4, info.getBirth());
				ps.setString(5, info.getGender());
				ps.setString(6, info.getpNum());
				ps.setString(7, info.getContent());
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		public HashMap<Integer, String> profileShow(String userId) {
			String sql = "select * from profile where id = '" + userId + "'";
			HashMap<Integer, String> map = new HashMap<Integer, String>();
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					map.put(1, rs.getString("name"));
					map.put(2, rs.getString("age"));
					map.put(3, rs.getString("birth"));
					map.put(4, rs.getString("gender"));
					map.put(5, rs.getString("pnum"));
					map.put(6, rs.getString("content"));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return map;
		}
		public String profileExist(String userId) {
			String sql = "select name from profile where id = '" + userId + "'";
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getString("name");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		public int profileUpdate(Information info, String userId) {
			String sql = "update profile set name=?, age=?, birth=?, gender=?, pnum=?, content=? where id = '" + userId + "'";
			int result = 0;
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps  = con.prepareStatement(sql);
				ps.setString(1, info.getName());
				ps.setString(2, info.getAge());
				ps.setString(3, info.getBirth());
				ps.setString(4, info.getGender());
				ps.setString(5, info.getpNum());
				ps.setString(6, info.getContent());
				ps.executeQuery();
				result = ps.executeUpdate();  // select를 제외한 나머지는 update를 씀
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		public int saveImagePath(ImageDTO dto) {
			String sql = "insert into imagepath(id, serialNum, path, time) values(?, ?, ?, ?)";
			int result = 0;
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dto.getId());
				ps.setInt(2, dto.getSerialNum());
				ps.setString(3, dto.getPath());
				ps.setString(4, dto.getTime());
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		public HashMap<Integer, String> showImage(String userId) {
			String sql = "select serialNum, path, time from imagepath where id = '" + userId + "'";
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					String time = rs.getString("time");
					String content = time + "\n" + rs.getString("path");
					imageMap.put(rs.getInt("serialNum"), content);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return imageMap;
		}
		public int serialNumber(String userId) {
			int num = 0;
			String sql = "select serialNum from imagepath where id = '" + userId + "'";
			try {
				Connection con = DriverManager.getConnection(url, id, pwd);
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					if(num < rs.getInt("serialNum")) {
						num = rs.getInt("serialNum");
					}
				}
				num += 1;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return num;
		}

}









