package ex01.join;

import java.net.URL;
import java.util.ResourceBundle;


import ex01.common.CommonClass;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.memberdto.MemberDTO;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class JoinController extends CommonClass implements Initializable{
	Parent root;
	DatabaseService ds;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	public void btnOk() {
		System.out.println("OK Ŭ��");
		TextField id = (TextField)root.lookup("#fxId");
		TextField pw = (TextField)root.lookup("#fxPw");
		TextField name = (TextField)root.lookup("#fxName");
		TextField p_num = (TextField)root.lookup("#fxP_num");
		System.out.println("���̵� : "+id.getText());
		System.out.println("��й�ȣ : "+pw.getText());
		System.out.println("�̸� : "+name.getText());
		System.out.println("��ȭ��ȣ : "+p_num.getText());
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id.getText());
		dto.setPw(pw.getText());
		dto.setName(name.getText());
		dto.setP_num(p_num.getText());
		ds = new DatabaseServiceImpl();
		int result = ds.saveMember(dto);
		if(result == 1) {
			alert("���������� ���ԵǾ����ϴ�");
			exit(root);
		}else {
			alert("���Կ� �����߽��ϴ�");
			
		
		}
		
	}
	
	public void btnBack() {
		System.out.println("Back Ŭ��");
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	


}
