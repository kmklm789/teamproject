package ex01.forgot2;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ForgotController2 extends CommonClass implements Initializable{
	Parent root;
	
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

	public void btnOK() {
		System.out.println("OK 클릭");
		
		TextField name = (TextField)root.lookup("#fxName");
		TextField p_num = (TextField)root.lookup("#fxP_num");
		
		System.out.println("name : "+name.getText());
		System.out.println("p_num : "+p_num.getText());
		
		DatabaseService ds = new DatabaseServiceImpl();
		String dbid = ds.loginCheck2(name.getText(), p_num.getText());

		
		if(dbid == null) {
			alert("정보가 일치하지않습니다");
		}
		else  {
			alert("ID :"+(dbid));
		}
	}
	
	public void btnBack() {
		System.out.println("Back 클릭");
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
}
