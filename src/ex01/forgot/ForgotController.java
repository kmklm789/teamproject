package ex01.forgot;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.forgot2.ForgotMain2;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ForgotController extends CommonClass implements Initializable{
	Parent root;
	ForgotMain2 forgot02 = new ForgotMain2();
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	public void btnOK() {
		System.out.println("OK 클릭");
		TextField id = (TextField)root.lookup("#fxId");
		TextField name = (TextField)root.lookup("#fxName");
		TextField p_num = (TextField)root.lookup("#fxP_num");
		
		System.out.println("입력된 정보");
		System.out.println("id : "+id.getText());
		System.out.println("name : "+name.getText());
		System.out.println("p_num : "+p_num.getText());
		
		DatabaseService ds = new DatabaseServiceImpl();

		String dbPwd = ds.loginCheck1(id.getText(), name.getText(), p_num.getText());

		
		if(dbPwd == null) {
			alert("정보가 일치하지않습니다");
		}
		else  {
			alert("비밀번호: "+(dbPwd));
			}
		}
		
	
	
	public void btnFID() {
		System.out.println("Forgot ID 클릭");
		forgot02.setForgot2Stage();
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}

}
