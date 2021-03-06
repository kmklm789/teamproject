package ex01.loginService;

import ex01.common.CommonClass;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.mainPage.PageMain;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginServiceImpl extends CommonClass implements LoginService {
	@Override
	public void loginCheck(Parent root) {
		TextField id = (TextField) root.lookup("#fxId");
		TextField pwd = (TextField) root.lookup("#fxPw");


		System.out.println("로그인 체크 합니다");
		System.out.println("id : " + id.getText());
		System.out.println("pwd : " + pwd.getText());

		DatabaseService ds = new DatabaseServiceImpl();
		String dbPwd = ds.loginCheck(id.getText());

		if (id.getText().isEmpty()==true) {

			alert("아이디를 입력하세요");
		} else {
			if (dbPwd == null) {
				alert("존재하지 않는 아이디 입니다");
			} else {
				if (dbPwd.equals(pwd.getText())) {
					Stage stage = (Stage)root.getScene().getWindow();
					stage.close();
					PageMain page = new PageMain();
					page.getMyId(id.getText());
					page.setMainStage();
				} else {
					alert("비밀번호가 틀렸습니다");
				}
			}
		}
	}
}

