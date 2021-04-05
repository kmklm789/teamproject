package ex01.database;

import java.util.HashMap;

import ex01.imagedto.ImageDTO;
import ex01.mainPage.diarydto.DiaryDTO;
import ex01.mainPage.profile.Information;
import ex01.mainPage.profile.profiledto.ProfileDTO;
import ex01.memberdto.MemberDTO;
import ex01.visitordto.VisitorDTO;

public interface DatabaseService {
	public int saveMember( MemberDTO dto );
	public String loginCheck(String userId);
	public String loginCheck1(String userId, String username, String userp_num);
	public String loginCheck2(String username, String userp_num);
	public int saveDiary(DiaryDTO diaryDto);
	public HashMap<Integer, String> showDiary(String userId);
	public int diarySerialNum(String userId);
	public int saveVisitor(VisitorDTO visitDto);
	public HashMap<Integer, String> showVisitor(String userId);
	public int visitorSerialNum(String userId);
	public int saveImagePath(ImageDTO dto);
	public HashMap<Integer, String> showImage(String userId);
	public int serialNumber(String userId);
	public int profileImage(ProfileDTO dto);
	public String profileImageShow(String userId);
	public int profileImageUpdate(String id, String path);
	public int profileImageDelete(String userId);
	public int profileSave(Information info);
	public HashMap<Integer, String> profileShow(String id);
	public String profileExist(String userId);
	public int profileUpdate(Information info, String userId);
}
