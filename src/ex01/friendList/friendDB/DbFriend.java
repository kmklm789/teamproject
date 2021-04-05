package ex01.friendList.friendDB;

import java.util.ArrayList;

import ex01.friendList.checkdto.CheckDTO;
import ex01.memberdto.MemberDTODH;

public interface DbFriend {
	public int saveMember(MemberDTODH a);
	public String loginCheck(String userId);
	public int saveMember(CheckDTO dto);
	public ArrayList<String> dbClass(String myId);
	

}
