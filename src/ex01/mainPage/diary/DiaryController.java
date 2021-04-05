package ex01.mainPage.diary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.common.CommonService;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.mainPage.PageController;
import ex01.mainPage.diarydto.DiaryDTO;
import ex01.mainPage.time.TimeService;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class DiaryController implements Initializable {
	Parent root;
	Parent pageRoot;
	String userId;
	PageController pc;
	int i = 0;
	public static CommonService cs;
	static {
		cs = new CommonClass();
	}
	public void setRoot(Parent root, String userId, Parent pageRoot) {
		this.root = root;
		this.userId = userId;
		this.pageRoot = pageRoot;
	}
	public void saveDiary() {
		TextArea content = (TextArea)root.lookup("#content");
		System.out.println(content.getText());
		DiaryDTO dto = new DiaryDTO();
		DatabaseService ds = new DatabaseServiceImpl();
		TimeService ts = new TimeService();
		i = ds.diarySerialNum(userId);
		String time = ts.getTime();
		System.out.println(time);
		dto.setId(userId);
		dto.setSerialNum(i);
		dto.setContent(content.getText());
		dto.setTime(time);
		int result  = ds.saveDiary(dto);
		if(result == 1) {
			DiaryController.cs.exit(root);
			System.out.println("저장 완료");
			System.out.println(userId);
			callMain();
			pc.diaryExit(pageRoot);
		}
	}
	public void cancelDiary() {
		System.out.println("취소 버튼 클릭");
		DiaryController.cs.exit(root);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pc = new PageController();
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
		controller.setRoot(root, userId);

		stage.setScene(scene);
		stage.show();
	}
}
