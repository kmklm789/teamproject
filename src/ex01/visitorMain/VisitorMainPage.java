package ex01.visitorMain;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VisitorMainPage {
	String friendId;
	String myId;

	public void setMainStage() {
		
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("VisitorMainPage.fxml"));

		Parent root = null;
		
		try {
			root = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Scene scene = new Scene(root);

		VisitorController controller = loader.getController();
		controller.setRoot(root, friendId, myId);

		stage.setScene(scene);
		stage.show();
	}
	
	public void getMyId(String friendId, String myId) {
		this.friendId = friendId;
		this.myId = myId;
	}

}
