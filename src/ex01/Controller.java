package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.forgot.ForgotMain;
import ex01.join.JoinMain;
import ex01.loginService.LoginService;
import ex01.loginService.LoginServiceImpl;
import ex01.mainPage.PageMain;
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
	LoginService ls;
	
	public void setRoot(Parent root) {
		System.out.println(root);
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginServiceImpl();
		Image image = new Image("Logo.jpg");
		imageView.setImage(image);
	}
	
	public void btnLogin() {
		ls.loginCheck(root);

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
