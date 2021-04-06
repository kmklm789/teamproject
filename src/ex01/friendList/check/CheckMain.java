package ex01.friendList.check;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CheckMain  {

	public void setCheckStage(String userId, String myId, Parent mainPageRoot) {
		Stage stage = new Stage();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("checkTest.fxml"));
		Parent root = null; //초기화
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		
		CheckController controller = loader.getController();
		controller.setRoot(root, userId, myId, mainPageRoot);
		Label id = (Label)root.lookup("#fxRead");
		System.out.println("아이디 출력 : "+id.getText()); 
		id.setText(userId);
		
		stage.setScene(scene);
    	stage.show();
	}
}
