package ex01.database;

import ex01.memberdto.MemberDTO;

public interface DatabaseService {
	public int saveMember( MemberDTO dto );
	public String loginCheck(String userId);
	public String loginCheck1(String userId, String username, String userp_num);
	public String loginCheck2(String username, String userp_num);
}
