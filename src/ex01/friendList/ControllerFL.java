package ex01.friendList;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.common.CommonService;
import ex01.friendList.ControllerFL;
import ex01.friendList.findId.FindIdMain;
import ex01.friendList.friendDB.DbFriend;
import ex01.friendList.friendDB.DbFriendImpl;
import ex01.mainPage.PageController;
import ex01.mainPage.media.MediaService;
import ex01.mainPage.media.MediaServiceImpl;
import ex01.mainPage.mediaInterface.mediaInter;
import ex01.visitorMain.VisitorMainPage;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;

public class ControllerFL implements Initializable, mediaInter {
	Parent root;
	Parent mainPageRoot;
	FindIdMain mm;
	String myId;
	VisitorMainPage vmp;
	
	public static CommonService cs;
	static {cs = new CommonClass();}
	
	public void addComboBox() {
		DbFriend ds = new DbFriendImpl();
		ArrayList<String> as = ds.dbClass(myId);
		
		ComboBox<String> cmb = (ComboBox<String>)root.lookup("#cmbFriend");
		if(cmb != null) {
			for(int i = 0; i < as.size(); i++) {
				System.out.println(as.get(i));
				cmb.getItems().addAll(as.get(i));
			}
		}
	}
	public void memberProc() {
		System.out.println("등록하기 클릭");
		ControllerFL.cs.exit(root);
		mm.getMyId(mainPageRoot, myId);
		mm.setMemberStage();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mm = new FindIdMain(); //창을 하나 더 뜨게 하는 것
		vmp = new VisitorMainPage();
	}
	public String getComboBox() {
		ComboBox<String> cmb = (ComboBox<String>)root.lookup("#cmbFriend");
		String friend = cmb.getValue();
		if(friend == null) {
			ControllerFL.cs.alert("콤보박스를 선택해주세요");
		}
		return friend;
	}

	public void move() {
		String friendId =  getComboBox();
		ControllerFL.cs.exit(root);
		ms.MusicStop();
		PageController.cs.exit(mainPageRoot);
		vmp.getMyId(friendId, myId);
		vmp.setMainStage();
	}

	public void setRoot(Parent root, String myId, Parent mainPageRoot) {
		this.root = root;
		this.myId = myId;
		this.mainPageRoot = mainPageRoot;
		addComboBox();
	}
}
