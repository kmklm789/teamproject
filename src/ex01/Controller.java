package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.forgotPwd.ForgotPWDMain;
import ex01.join.JoinMain;
import ex01.loginService.LoginService;
import ex01.loginService.LoginServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller extends CommonClass implements Initializable {

	@FXML
	ImageView imageView;
	ForgotPWDMain forgot01 = new ForgotPWDMain();
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
		Image image = new Image("images/Logo.jpg");
		imageView.setImage(image);
	}

	public void btnLogin() {
		ls.loginCheck(root);

	}

	public void btnForgot() {
		//System.out.println("Forgot 클릭");
		forgot01.setForgotStage();
	}

	public void btnJoin() {
		//System.out.println("Join 클릭");
		join.setJoinStage();
	}

}
