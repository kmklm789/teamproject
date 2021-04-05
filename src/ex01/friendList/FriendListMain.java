package ex01.friendList;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FriendListMain {
	String myId;

	public void setFriendStage() {
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("friendList.fxml"));
		Parent root = null;
		
		try {
			root = loader.load();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root);
		

		ControllerFL controller = loader.getController();
		controller.setRoot(root, myId);
		
		stage.setScene(scene);
		stage.show();
	}
	public void getMyId(String myId) {
		this.myId = myId;
	}

}
