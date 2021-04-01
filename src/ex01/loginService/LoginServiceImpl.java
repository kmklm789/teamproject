package ex01.loginService;

import ex01.common.CommonClass;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.mainPage.PageMain;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginServiceImpl extends CommonClass implements LoginService {
	@Override
	public void loginCheck(Parent root) {
		TextField id = (TextField) root.lookup("#fxId");
		TextField pwd = (TextField) root.lookup("#fxPw");

		System.out.println("�α��� üũ �մϴ�");
		System.out.println("id : " + id.getText());
		System.out.println("pwd : " + pwd.getText());

		DatabaseService ds = new DatabaseServiceImpl();
		String dbPwd = ds.loginCheck(id.getText());

		if (id.getText().isEmpty()==true) {
			alert("���̵� �Է��ϼ���");
		} else {
			if (dbPwd == null) {
				alert("�������� �ʴ� ���̵� �Դϴ�");
			} else {
				if (dbPwd.equals(pwd.getText())) {
					alert("���� ���");
					PageMain page = new PageMain();
					page.setMainStage();
				} else {
					alert("��й�ȣ�� Ʋ�Ƚ��ϴ�");
				}
			}
		}
	}
}

//		if(dbPwd == null) {
//			alert("�������� �ʴ� ���̵� �Դϴ�");
//		}else {
//			if( dbPwd.equals(pwd.getText()) ) {
//				alert("���� ���");
//			}else {
//				alert("��й�ȣ�� Ʋ�Ƚ��ϴ�");
//			}
//		}
