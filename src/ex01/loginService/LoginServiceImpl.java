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

<<<<<<< HEAD
		System.out.println("�α��� üũ �մϴ�");
=======
		System.out.println("로그인 체크 합니다");
>>>>>>> 6f87e5a5fb6890c4eb8a45d1c8dd62774f8b5cea
		System.out.println("id : " + id.getText());
		System.out.println("pwd : " + pwd.getText());

		DatabaseService ds = new DatabaseServiceImpl();
		String dbPwd = ds.loginCheck(id.getText());

		if (id.getText().isEmpty()==true) {
<<<<<<< HEAD
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
=======
			alert("아이디를 입력하세요");
		} else {
			if (dbPwd == null) {
				alert("존재하지 않는 아이디 입니다");
			} else {
				if (dbPwd.equals(pwd.getText())) {
					alert("인증 통과");
				} else {
					alert("비밀번호가 틀렸습니다");
>>>>>>> 6f87e5a5fb6890c4eb8a45d1c8dd62774f8b5cea
				}
			}
		}
	}
}
<<<<<<< HEAD

//		if(dbPwd == null) {
//			alert("�������� �ʴ� ���̵� �Դϴ�");
//		}else {
//			if( dbPwd.equals(pwd.getText()) ) {
//				alert("���� ���");
//			}else {
//				alert("��й�ȣ�� Ʋ�Ƚ��ϴ�");
//			}
//		}
=======
>>>>>>> 6f87e5a5fb6890c4eb8a45d1c8dd62774f8b5cea
