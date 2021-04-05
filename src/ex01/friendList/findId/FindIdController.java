package ex01.friendList.findId;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ex01.friendList.ControllerFL;
import ex01.friendList.check.CheckMain;
import ex01.friendList.entFriend.EntFriend;
import ex01.friendList.entFriend.EntFriendImpl;
import ex01.friendList.friendDB.DbFriend;
import ex01.friendList.friendDB.DbFriendImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FindIdController implements Initializable {
	@FXML
	TextField fxid;
	Parent root;
	EntFriend ls;;
	CheckMain cm;
	String myId;

	public void setRoot(Parent root, String myId) {
		this.root = root;
		this.myId = myId;
		System.out.println(myId);
		ls.setRoot(root);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new EntFriendImpl();
		cm = new CheckMain();
	}

	public void memberProc() {
		System.out.println("확인버튼");
		TextField id = (TextField) root.lookup("#fxId");

		if (id.getText().isEmpty()) {
			ControllerFL.cs.alert("아이디를 입력하세요");
		} else {
			System.out.println("id : " + id.getText());
			DbFriend ds = new DbFriendImpl();
			String dbId = ds.loginCheck(id.getText());
			if (dbId == null) {
				ControllerFL.cs.alert("존재하지 않는 id입니다");
				// 등록하시겠습니까? 예-등록되었습니다 아니오-취소되었습니다

			} else {
				cm.setCheckStage(id.getText(), myId);
				ControllerFL.cs.exit(root);
			}
		}

	}

	public void cancelProc() { // 취소버튼 연결
		System.out.println("취소버튼");

		ls.memberClose();
		callMain();
	}

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
		controller.setRoot(root, myId);

		stage.setScene(scene);
		stage.show();
	}
}
