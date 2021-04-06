package ex01.mainPage.profile;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.common.CommonService;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.mainPage.PageController;
import ex01.mainPage.media.MediaService;
import ex01.mainPage.media.MediaServiceImpl;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProfileController implements Initializable {
	Parent root;
	Parent pageRoot;
	String id;
	DatabaseService ds;
	PageController pc;
	public static CommonService cs;
	static {
		cs = new CommonClass();
	}
	public void setRoot(Parent root, Parent pageRoot, String id) {
		this.root = root;
		this.pageRoot = pageRoot;
		this.id = id;
	}
	public void saveProfile() {
		String gender = getGender();
		TextField name = (TextField)root.lookup("#fxName");
		TextField age = (TextField)root.lookup("#fxAge");
		TextField birth = (TextField)root.lookup("#fxBirth");
		TextField pNum = (TextField)root.lookup("#phoneNum");
		
		CheckBox chkAge = (CheckBox)root.lookup("#chkAge");
		CheckBox chkBirth = (CheckBox)root.lookup("#chkBirth");
		CheckBox chkGender = (CheckBox)root.lookup("#chkGender");
		CheckBox chkPhone = (CheckBox)root.lookup("#chkPhone");
		
		TextArea information = (TextArea)root.lookup("#information");
		
		Information info = new Information();
		info.setId(id);
		info.setName(name.getText());
		if(chkAge.isSelected()) {
			info.setAge("비공개");
		}else {
			info.setAge(age.getText());
		}
		if(chkBirth.isSelected()) {
			info.setBirth("비공개");
		}else {
			info.setBirth(birth.getText());
		}
		if(chkPhone.isSelected()) {
			info.setpNum("비공개");
		}else {
			info.setpNum(pNum.getText());
		}
		if(chkGender.isSelected()) {
			info.setGender("비공개");
		}else {
			info.setGender(gender);
		}
		info.setContent(information.getText());
		
		System.out.println("아이디 : " + info.getId());
		System.out.println("이름 : " + info.getName());
		System.out.println("나이 : " + info.getAge());
		System.out.println("성별 : " + info.getGender());
		System.out.println("번호 : " + info.getpNum());
		System.out.println("소개글 : " + info.getContent());
		
		String exist = ds.profileExist(id);
		if(exist == null) {
			int result = ds.profileSave(info);
			if(result == 1) {
				ProfileController.cs.exit(root);
				callMain();
				pc.MusicPause();
				PageController.cs.exit(pageRoot);
			}else {
				ProfileController.cs.alert("모든 정보를 입력하세요");
			}
		}else {
			int result = ds.profileUpdate(info, id);
			if(result == 1) {
				ProfileController.cs.exit(root);
				callMain();
				pc.MusicPause();
				PageController.cs.exit(pageRoot);
			}else {
				ProfileController.cs.alert("모든 정보를 입력하세요");
			}
		}
	}
	public void cancelProfile() {
		System.out.println("취소 버튼 클릭");
		ProfileController.cs.exit(root);
	}
	
	public String getGender() {
		String gender;
		RadioButton man = (RadioButton)root.lookup("#fxMan");
		if(man.isSelected()) {	// 남자가 선택되어 있으면 true, 아니면 false
			gender = "남자";
		}else {
			gender = "여자";
		}
		return gender;
	}
	public void callMain() {
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../MainPage.fxml"));

		Parent root = null;
		
		try {
			root = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Scene scene = new Scene(root);

		PageController controller = loader.getController();
		controller.setRoot(root, id);

		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ds = new DatabaseServiceImpl();
		pc = new PageController();
	}

}
