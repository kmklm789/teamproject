package ex01.friendList.entFriend;

import ex01.friendList.ControllerFL;
import ex01.friendList.friendDB.DbFriend;
import ex01.friendList.friendDB.DbFriendImpl;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class EntFriendImpl implements EntFriend{
	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	@Override
	public void loginCheck(Parent root) {
		TextField id = (TextField)root.lookup("#fxId");

		if(id.getText().isEmpty()) {
			ControllerFL.cs.alert("아이디를 입력하세요");
		}
		System.out.println("id : "+id.getText());

		DbFriend ds = new DbFriendImpl();
		String dbId = ds.loginCheck(id.getText());
		if(dbId == null) {
			ControllerFL.cs.alert("존재하지 않는 아이디입니다");
		}else {
			if( dbId.equals(id.getText()) ) {
				ControllerFL.cs.alert("인증 통과");
			}

		}
	}

	

	@Override
	public void memberClose() {
		ControllerFL.cs.exit(root);
		
	}

}
