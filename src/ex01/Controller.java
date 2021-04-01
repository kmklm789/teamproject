package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.forgot.ForgotMain;
import ex01.join.JoinMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller extends CommonClass implements Initializable{

	@FXML ImageView imageView;
	ForgotMain forgot01 = new ForgotMain();
	JoinMain join = new JoinMain(); 
	Parent root;
	
	
	//@FXML TextField fxId;
	
	public void setRoot(Parent root) {
		System.out.println(root);
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image image = new Image("Logo.jpg");
		imageView.setImage(image);
		
	}
	
	public void btnLogin() {
		System.out.println("Login 클릭'"+root);
		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPw");
		
		if(id.getText().isEmpty()) {
			alert("아이디를 입력하세요");
		}
		
		System.out.println("로그인 체크 합니다");
		System.out.println("id : "+id.getText());
		System.out.println("pwd : "+pwd.getText());
		
		DatabaseService ds = new DatabaseServiceImpl();
		String dbPwd = ds.loginCheck(id.getText());
		
		if(dbPwd == null) {
			alert("존재하지 않는 아이디 입니다");
		}else {
			if( dbPwd.equals(pwd.getText()) ) {
				alert("인증 통과");
			}else {
				alert("비밀번호가 틀렸습니다");
			}
		}
	}

	
	
	public void btnForgot() {
		System.out.println("Forgot 클릭");
		forgot01.setForgotStage();
	}
	
	public void btnJoin() {
		System.out.println("Join 클릭");
		join.setJoinStage();
	}

	
}
