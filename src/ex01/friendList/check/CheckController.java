package ex01.friendList.check;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ex01.friendList.ControllerFL;
import ex01.friendList.checkdto.CheckDTO;
import ex01.friendList.friendDB.DbFriend;
import ex01.friendList.friendDB.DbFriendImpl;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CheckController implements Initializable{
	Parent root;
	Parent mainPageRoot;
	CheckMain cm;
	String userId, myId;

	public void setRoot(Parent root, String userId, String myId, Parent mainPageRoot) {
		this.root = root;
		this.userId = userId;
		this.myId = myId;
		this.mainPageRoot = mainPageRoot;
	}
	public void okProc() {
		System.out.println("네 클릭");


		CheckDTO dto = new CheckDTO();
		dto.setFriend_id(userId);
		System.out.println(myId);
		dto.setMy_id(myId);
		
		DbFriend ds = new DbFriendImpl();
		int result = ds.saveMember(dto);
		if(result ==1) {
			ControllerFL.cs.alert("성공적으로 등록되었습니다");
			ControllerFL.cs.exit(root);
			callMain();
		}else {
			ControllerFL.cs.alert("등록에 실패했습니다");
			ControllerFL.cs.exit(root);
			callMain();
		}
	}

	public void noProc() {
		System.out.println("아니요 클릭");
		ControllerFL.cs.exit(root);
		callMain();
		//cm.setMemberStage();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
//	public void getMyId(String myId) {
//		this.myId = myId;
//	}
	public void callMain() {
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../friendList.fxml"));

		Parent root = null;
		
		try {
			root = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Scene scene = new Scene(root);

		ControllerFL controller = loader.getController();
		controller.setRoot(root, myId, mainPageRoot);

		stage.setScene(scene);
		stage.show();
	}

}
